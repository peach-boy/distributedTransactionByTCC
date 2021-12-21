package com.wxt.payment.service.helper;

import com.wxt.payment.domain.mapper.PayOrderMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Component
public class DeadLockHelpler {

    @Resource
    private PayOrderMapper payOrderMapper;

    @Transactional
    public void test(String outerTradeNo1, String outerTradeNo2,Integer sleepNum) {
        payOrderMapper.updateStatus(outerTradeNo1, 1, 4);
        try {
            Thread.sleep(1000 * sleepNum);
        } catch (Exception e) {
            e.printStackTrace();
        }
        payOrderMapper.updateStatus(outerTradeNo2, 1, 4);

    }
}
