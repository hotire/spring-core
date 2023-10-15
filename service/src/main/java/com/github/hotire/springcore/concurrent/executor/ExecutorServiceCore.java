package com.github.hotire.springcore.executor;

import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @see ExecutorService
 * @see AbstractExecutorService
 */
public interface ExecutorServiceCore {


    /**
     * @see ExecutorService#shutdown()
     */
    void shutdown();


    /**
     * @see ExecutorService#awaitTermination(long, TimeUnit) 
     */
    boolean awaitTermination(long timeout, TimeUnit unit)
        throws InterruptedException;
}
