package com.wxt.payment.manager.lock;

import java.util.concurrent.TimeUnit;

public class DLockBaseInfo {
    private String lockPrefix;

    private long lockTime;

    private TimeUnit unit;

    public static DLockBaseInfo newInstance(String lockPrefix, long lockTime, TimeUnit unit) {
        DLockBaseInfo dLockBaseInfo = new DLockBaseInfo();
        dLockBaseInfo.setLockPrefix(lockPrefix);
        dLockBaseInfo.setLockTime(lockTime);
        dLockBaseInfo.setUnit(unit);
        return dLockBaseInfo;
    }

    public String getLockPrefix() {
        return lockPrefix;
    }

    public void setLockPrefix(String lockPrefix) {
        this.lockPrefix = lockPrefix;
    }

    public long getLockTime() {
        return lockTime;
    }

    public void setLockTime(long lockTime) {
        this.lockTime = lockTime;
    }

    public TimeUnit getUnit() {
        return unit;
    }

    public void setUnit(TimeUnit unit) {
        this.unit = unit;
    }
}
