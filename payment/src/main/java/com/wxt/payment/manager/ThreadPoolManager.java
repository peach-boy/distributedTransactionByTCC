package com.wxt.payment.manager;

import com.wxt.payment.manager.lock.DLockManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定义线程池
 */
@Component
public class ThreadPoolManager extends ThreadPoolExecutor {

    private static final Logger LOGGER = LoggerFactory.getLogger(DLockManager.class);

    public ThreadPoolManager() {
        super(5,
                10,
                10,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(1000),
                (r, e) -> LOGGER.error("触发拒绝策略：{}", e.getActiveCount()));
    }
}


