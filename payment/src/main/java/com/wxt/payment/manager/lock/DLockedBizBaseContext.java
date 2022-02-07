package com.wxt.payment.manager.lock;

import com.wxt.payment.manager.tcc.TCCContext;

/**
 * 分布式锁业务体，入参基类
 */
public class DLockedBizBaseContext extends TCCContext {
    private String lockKey;

    public String getLockKey() {
        return lockKey;
    }

    public void setLockKey(String lockKey) {
        this.lockKey = lockKey;
    }
}
