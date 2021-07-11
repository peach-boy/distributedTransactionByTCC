package com.wxt.payment.web.aspect;

import com.wxt.common.constant.RedisLock;
import com.wxt.common.exception.BusinessRuntimeException;
import com.wxt.payment.manager.RedisManager;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.UUID;

@Aspect
@Component
public class RedisLockHandler {

    @Autowired
    private RedisManager redisManager;


    @Around("@annotation(com.wxt.common.constant.RedisLock)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        RedisLock redisLock = method.getAnnotation(RedisLock.class);

        String lockValue = UUID.randomUUID().toString();
        try {
            //加锁操作
            Boolean lockResult = redisManager.lock(redisLock.keyPrefix(), lockValue, redisLock.expire(), redisLock.expireTimeUnit());
            if (!lockResult) {
                throw new BusinessRuntimeException(redisLock.unLockrroCode());
            }

            //执行业务
            return joinPoint.proceed();

        } finally {
            //释放锁
            redisManager.releaseLock(redisLock.keyPrefix());
        }


    }


}
