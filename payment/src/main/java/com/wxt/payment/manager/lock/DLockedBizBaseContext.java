package com.wxt.payment.manager.lock;

/**
 * 分布式锁业务体，入参基类
 */
public abstract class DLockedBizBaseContext {
    private String lockKey;

    public String getLockKey() {
        return lockKey;
    }

    public void setLockKey(String lockKey) {
        this.lockKey = lockKey;
    }
}
