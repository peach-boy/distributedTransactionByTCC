package com.wxt.payment.manager.tcc;


/**
 * @Auther: ThomasWu
 * @Date: 2021/6/6 14:00
 * @Description:TCC处理器
 */
public interface TCCProcessor<T extends TCCContext> {

    /**
     * 锁定资源
     */
    void tryStage(T context);

    /**
     * 扣除资源
     */
    void comfirmStage(T context);

    /**
     * 释放锁定资源
     */
    void cancelStage(T context);

}
