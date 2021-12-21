package com.wxt.payment.manager;


import com.wxt.common.constant.ErrorCode;
import com.wxt.common.exception.BusinessRuntimeException;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class DLockManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(DLockManager.class);


    @Autowired
    private RedissonClient redissonClient;


    public void lockAround(DLockedBizBaseContext context,DLockedBiz dLockedBiz){
        RLock lock = redissonClient.getLock("pay_lock_" + context.getLockKey());

        //加锁
        lock.lock(10, TimeUnit.SECONDS);

        try {
            boolean result = lock.tryLock();
            if (!result) {
                throw new BusinessRuntimeException(ErrorCode.DISTRIBUTE_LOCKING);
            }

            dLockedBiz.execute(context);

        } catch (Exception e) {
            LOGGER.error("error:{}",e);
            throw e;
        } finally {
            //释放锁
            lock.unlock();
        }
    }
}
