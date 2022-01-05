package com.wxt.payment.service.scene;

import com.wxt.payment.model.PayContext;
import com.wxt.payment.service.processor.AccountPayProcessor;
import com.wxt.payment.service.processor.PayProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: ThomasWu
 * @Date: 2021/6/6 13:57
 * @Description:支付场景抽象类
 */
public abstract class AbstractScene {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractScene.class);

    protected List<PayProcessor> payProcessorList = new ArrayList<>();

    abstract String sceneCode();

    abstract void registerProcessor();


    @PostConstruct
    void init() {
        this.registerProcessor();
    }


    public Boolean execute(PayContext payContext) {
        //try阶段
        int currentTryStage = 0;
        try {
            for (; currentTryStage < payProcessorList.size(); currentTryStage++) {
                PayProcessor payProcessor = payProcessorList.get(currentTryStage);
                payProcessor.tryPay(payContext);
            }
        } catch (Exception e) {
            LOGGER.error("try_pay_error:{}", e);

            //执行cancel
            int i = currentTryStage;
            while (i >= 0) {
                payProcessorList.get(i).cancelPay(payContext);
                i--;
            }

            return Boolean.FALSE;
        }

        //comfirm阶段
        int currentComfirmStage = 0;
        for (; currentComfirmStage < payProcessorList.size(); currentComfirmStage++) {
            PayProcessor payProcessor = payProcessorList.get(currentComfirmStage);
            payProcessor.comfirmPay(payContext);
        }


        return Boolean.TRUE;
    }

}
