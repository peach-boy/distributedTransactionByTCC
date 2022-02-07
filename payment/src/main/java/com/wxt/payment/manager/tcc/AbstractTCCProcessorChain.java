package com.wxt.payment.manager.tcc;

import com.wxt.payment.service.scene.Scene;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * TCC处理器链
 */
public abstract class AbstractTCCProcessorChain {

    private static final Logger LOGGER = LoggerFactory.getLogger(Scene.class);

    protected List<TCCProcessor> processorList;

    public abstract List<TCCProcessor> registerProcessor();

    @PostConstruct
    void init() {
        processorList = this.registerProcessor();
    }


    public Boolean execute(TCCContext context) {
        //try阶段
        int currentTryStage = 0;
        try {
            for (; currentTryStage < processorList.size(); currentTryStage++) {
                processorList.get(currentTryStage).tryStage(context);
            }
        } catch (Exception e) {
            LOGGER.error("try_pay_error:{}", e);

            //cancel阶段
            int i = currentTryStage;
            while (i >= 0) {
                processorList.get(i).cancelStage(context);
                i--;
            }

            return Boolean.FALSE;
        }

        //comfirm阶段
        int currentComfirmStage = 0;
        for (; currentComfirmStage < processorList.size(); currentComfirmStage++) {
            processorList.get(currentComfirmStage).comfirmStage(context);
        }

        return Boolean.TRUE;
    }
}
