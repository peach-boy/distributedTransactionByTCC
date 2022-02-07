package com.wxt.payment.service.scene;

import com.wxt.payment.manager.tcc.TCCProcessor;
import com.wxt.payment.service.processor.AccountProcessor;
import com.wxt.payment.service.processor.LimitProcessor;
import com.wxt.payment.service.processor.MarketProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: ThomasWu
 * @Date: 2021/6/6 13:56
 * @Description:额度支付场景
 */
@Service
public class LimitScene extends Scene {

    @Autowired
    private MarketProcessor marketPayProcessor;

    @Autowired
    private AccountProcessor accountPayProcessor;

    @Autowired
    private LimitProcessor limitPayProcessor;

    @Override
    String sceneCode() {
        return com.wxt.payment.model.Scene.LIMIT.getSceneCode();
    }

    @Override
    public List<TCCProcessor> registerProcessor() {
        List<TCCProcessor> processorList = new ArrayList<>();
        processorList.add(accountPayProcessor);
        processorList.add(limitPayProcessor);
        processorList.add(marketPayProcessor);
        return processorList;
    }
}
