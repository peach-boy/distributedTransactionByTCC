package com.wxt.payment.manager.lock;


import com.wxt.common.constant.ErrorCode;
import com.wxt.common.exception.BusinessRuntimeException;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 分布式锁
 */
@Component
public class DLockManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(DLockManager.class);

    @Autowired
    private RedissonClient redissonClient;

    /**
     * 加锁方法，DLockedBiz为锁定业务逻辑
     *
     * @param context
     * @param dLockBaseInfo
     * @param biz
     */
    public void lockBizAround(DLockedBizBaseContext context, DLockBaseInfo dLockBaseInfo, DLockedBiz biz) {
        RLock lock = redissonClient.getLock(dLockBaseInfo.getLockPrefix() + "_" + context.getLockKey());
        lock.lock(dLockBaseInfo.getLockTime(), dLockBaseInfo.getUnit());

        try {
            //获取锁
            boolean result = lock.tryLock();
            if (!result) {
                throw new BusinessRuntimeException(ErrorCode.DISTRIBUTE_LOCKING);
            }

            //执行业务逻辑
            biz.execute(context);
        } catch (Exception e) {
            LOGGER.error("error:{}", e);
            throw e;
        } finally {
            //释放锁
            lock.unlock();
        }
    }
}
