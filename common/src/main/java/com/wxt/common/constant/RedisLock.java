package com.wxt.common.constant;


import com.wxt.common.constant.ErrorCode;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;


/***
 * 加锁注解
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface RedisLock {

    String keyPrefix();

    /**
     * 锁过期时间
     *
     * @return
     */
    int expire() default 5;


    /**
     * 锁过期时间单位
     * @return
     */
    TimeUnit expireTimeUnit() default TimeUnit.SECONDS;

    /**
     * 锁超时时间
     *
     * @return
     */
    int waiteTime() default 0;

    /**
     * 锁的超时时间单位
     *
     * @return
     */
    TimeUnit waiteTimeUnit() default TimeUnit.SECONDS;


    /**
     * 为获取到锁返回的错误码
     *
     * @return
     */
    ErrorCode unLockrroCode() default ErrorCode.LOCKING;


}
