package com.wxt.payment.service.scene;

import com.wxt.payment.model.PayContext;
import com.wxt.payment.service.processor.PayProcessor;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: ThomasWu
 * @Date: 2021/6/6 13:57
 * @Description:
 */
public abstract class AbstractScene {
    protected List<PayProcessor> payProcessorList = new ArrayList<>();

    abstract String sceneCode();

    abstract void registerPayProcessor();

    @PostConstruct
    void init() {
        this.registerPayProcessor();
    }


    public Boolean doPay(PayContext payContext) {

        int currentStage = 0;
        try {
            for (; currentStage < payProcessorList.size(); currentStage++) {
                PayProcessor payProcessor = payProcessorList.get(currentStage);
                payProcessor.tryPay();
            }
        } catch (Exception e) {


        }

        return Boolean.TRUE;
    }

}
