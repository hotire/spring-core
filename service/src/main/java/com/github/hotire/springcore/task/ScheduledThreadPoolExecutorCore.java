package com.github.hotire.springcore.task;

/**
 * @see java.util.concurrent.ScheduledThreadPoolExecutor
 */
public class ScheduledThreadPoolExecutorCore {

    volatile boolean removeOnCancel;

    public void setRemoveOnCancelPolicy(boolean value) {
        removeOnCancel = value;
    }
}
