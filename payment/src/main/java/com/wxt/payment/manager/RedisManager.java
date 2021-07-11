package com.wxt.payment.manager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisManager {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public Boolean lock(String key, String value, long lockTime, TimeUnit timeUnit) {
        return stringRedisTemplate.opsForValue().setIfAbsent(key, value,lockTime,timeUnit);
    }

    public boolean releaseLock(String key){
       return stringRedisTemplate.delete(key);
    }



}
