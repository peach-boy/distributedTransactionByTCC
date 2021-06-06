package com.wxt.payment.model;

/**
 * @Auther: ThomasWu
 * @Date: 2021/6/6 14:23
 * @Description:
 */
public enum Scene {

    LIMIT("LIMIT");

    private String sceneCode;

    Scene(String sceneCode) {
        this.sceneCode = sceneCode;
    }

    public String getSceneCode() {
        return sceneCode;
    }
}
