package com.wxt.payment.service.processor;

/**
 * @Auther: ThomasWu
 * @Date: 2021/6/8 16:47
 * @Description:
 */
@FunctionalInterface
public interface RetryAction {
    void execute();
}
