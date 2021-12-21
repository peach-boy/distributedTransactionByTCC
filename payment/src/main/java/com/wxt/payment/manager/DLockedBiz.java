package com.wxt.payment.manager;

@FunctionalInterface
public interface DLockedBiz<T extends DLockedBizBaseContext> {
    void execute(T t);
}
