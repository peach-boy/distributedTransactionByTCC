package com.wxt.payment.service.processor;

/**
 * @Auther: ThomasWu
 * @Date: 2021/6/6 14:00
 * @Description:
 */
public interface PayProcessor {

    /**
     * 预扣除(锁定，冻结)
     */
    void tryPay();

    /**
     * 扣除确认（真实扣减）
     */
    void comfirmPay();

    /**
     * 扣除确认（真实扣减）
     */
    void cancelPay();

}
