package com.github.hotire.springcore.executor;

import java.util.HashSet;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @see ThreadPoolExecutor
 */
public class ThreadPoolExecutorCore {

    private final HashSet<Worker> workers = new HashSet<>();


    static class Worker {

    }


    /**
     * @see ThreadPoolExecutor#getTask()
     */
    private Runnable getTask() {
        return () -> {};
    }

}
