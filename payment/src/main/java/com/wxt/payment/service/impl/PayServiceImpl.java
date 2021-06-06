package com.wxt.payment.service.impl;

import com.wxt.payment.model.PayContext;
import com.wxt.payment.service.PayService;
import com.wxt.payment.service.scene.SceneRouter;
import org.springframework.stereotype.Service;

/**
 * @Auther: ThomasWu
 * @Date: 2021/6/6 13:52
 * @Description:
 */
@Service
public class PayServiceImpl implements PayService {
    @Override
    public Boolean pay(PayContext context) {
        return SceneRouter.getBySceneCode(context.getSceneCode()).doPay(context);
    }
}
