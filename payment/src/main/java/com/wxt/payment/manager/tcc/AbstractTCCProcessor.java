package com.wxt.payment.manager.tcc;

import com.wxt.common.constant.ErrorCode;
import com.wxt.common.exception.BusinessRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Auther: ThomasWu
 * @Date: 2021/6/8 16:22
 * @Description:处理器抽象类
 */
public abstract class AbstractTCCProcessor<T extends TCCContext> implements TCCProcessor<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractTCCProcessor.class);

    private int maxRetryNum = 2;

    private void retry(RetryAction retryAction) {
        try {
            retryAction.execute();
        } catch (Exception e) {
            if (maxRetryNum > 0) {
                LOGGER.info("重试:{}:{}次", retryAction.getClass().getName(), maxRetryNum);
                maxRetryNum--;
                retry(retryAction);
            } else {
                LOGGER.info("重试:{}:已达上限，请关注异常单", retryAction.getClass().getName());
                throw new BusinessRuntimeException(ErrorCode.SYSTEM_ERROR);
            }
        }
    }

    @Override
    public void tryStage(T context) {
        LOGGER.info("tryPay------{}", this.getClass().getName());
        this.doTry(context);
    }

    @Override
    public void comfirmStage(T context) {
        LOGGER.info("comfirmPay------{}", this.getClass().getName());
        this.retry(() -> this.doComfirm(context));
    }

    @Override
    public void cancelStage(T context) {
        LOGGER.info("cancelPay------{}", this.getClass().getName());
        this.retry(() -> this.doCancel(context));
    }


    public abstract Boolean doTry(T context);

    public abstract Boolean doComfirm(T context);

    public abstract Boolean doCancel(T context);

}
