package com.wxt.payment.manager.lock;

@FunctionalInterface
public interface DLockedBiz<T extends DLockedBizBaseContext> {
    void execute(T t);
}
