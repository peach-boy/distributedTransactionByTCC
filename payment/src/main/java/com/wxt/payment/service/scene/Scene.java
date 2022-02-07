package com.wxt.payment.service.scene;

import com.wxt.payment.manager.tcc.AbstractTCCProcessorChain;


/**
 * @Auther: ThomasWu
 * @Date: 2021/6/6 13:57
 * @Description:场景抽象类
 */
public abstract class Scene extends AbstractTCCProcessorChain {

    abstract String sceneCode();

}
