package com.wxt.payment.service.processor;

import com.wxt.payment.model.PayContext;

/**
 * @Auther: ThomasWu
 * @Date: 2021/6/6 14:00
 * @Description:
 */
public interface PayProcessor {

    /**
     * 预扣除(锁定，冻结)
     */
    void tryPay(PayContext payContext);

    /**
     * 扣除确认（真实扣减）
     */
    void comfirmPay(PayContext payContext);

    /**
     * 扣除确认（真实扣减）
     */
    void cancelPay(PayContext payContext);

}
