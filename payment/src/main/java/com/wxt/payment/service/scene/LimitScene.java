package com.wxt.payment.service.scene;

import com.wxt.payment.model.Scene;
import com.wxt.payment.service.processor.AccountPayProcessor;
import com.wxt.payment.service.processor.LimitPayProcessor;
import com.wxt.payment.service.processor.MarketPayProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: ThomasWu
 * @Date: 2021/6/6 13:56
 * @Description:额度支付场景
 */
@Service
public class LimitScene extends AbstractScene {

    @Autowired
    private MarketPayProcessor marketPayProcessor;

    @Autowired
    private AccountPayProcessor accountPayProcessor;

    @Autowired
    private LimitPayProcessor limitPayProcessor;

    @Override
    String sceneCode() {
        return Scene.LIMIT.getSceneCode();
    }

    @Override
    void registerProcessor() {
        this.payProcessorList.add(accountPayProcessor);
        this.payProcessorList.add(limitPayProcessor);
        this.payProcessorList.add(marketPayProcessor);
    }
}
