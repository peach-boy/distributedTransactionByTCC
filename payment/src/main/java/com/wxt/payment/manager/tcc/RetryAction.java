package com.wxt.payment.manager.tcc;

/**
 * @Auther: ThomasWu
 * @Date: 2021/6/8 16:47
 * @Description:重试函数接口
 */
@FunctionalInterface
public interface RetryAction {
    void execute();
}
