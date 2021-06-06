package com.wxt.payment.service.scene;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: ThomasWu
 * @Date: 2021/6/6 15:09
 * @Description:
 */
@Component
public class SceneRouter {

    @Resource
    private AbstractScene[] abstractSceneList;

    private static Map<String, AbstractScene> sceneMap;

    @PostConstruct
    private void init() {
        sceneMap = new HashMap<>();
        for (AbstractScene scene : abstractSceneList) {
            sceneMap.put(scene.sceneCode(), scene);
        }
    }

    public static AbstractScene getBySceneCode(String sceneCode) {
        AbstractScene abstractScene = sceneMap.get(sceneCode);
        if (abstractScene == null) {
            throw new RuntimeException();
        }
        return abstractScene;
    }
}
