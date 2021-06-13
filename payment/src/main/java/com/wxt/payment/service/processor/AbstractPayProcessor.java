package com.wxt.payment.service.processor;

import com.wxt.common.constant.ErrorCode;
import com.wxt.common.exception.BusinessRuntimeException;
import com.wxt.payment.model.PayContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Auther: ThomasWu
 * @Date: 2021/6/8 16:22
 * @Description:处理器抽象类
 */
public abstract class AbstractPayProcessor implements PayProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractPayProcessor.class);

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
    public void tryPay(PayContext payContext) {
        LOGGER.info("tryPay------{}", this.getClass().getName());
        this.doTryPay(payContext);
    }

    @Override
    public void comfirmPay(PayContext payContext) {
        LOGGER.info("comfirmPay------{}", this.getClass().getName());
        this.retry(() -> this.doComfirmPay(payContext));
    }

    @Override
    public void cancelPay(PayContext payContext) {
        LOGGER.info("cancelPay------{}", this.getClass().getName());
        this.retry(() -> this.doCancelPay(payContext));
    }


    public abstract Boolean doTryPay(PayContext payContext);

    public abstract Boolean doComfirmPay(PayContext payContext);

    public abstract Boolean doCancelPay(PayContext payContext);

}
