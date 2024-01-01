package com.github.hotire.springcore.task;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import lombok.RequiredArgsConstructor;
import org.springframework.core.task.TaskRejectedException;
import org.springframework.core.task.support.TaskExecutorAdapter;
import org.springframework.core.task.AsyncTaskExecutor;


/**
 * @see AsyncTaskExecutor
 * @see TaskExecutorAdapter
 */
@RequiredArgsConstructor
public class TaskExecutorAdapterCore {

    /**
     * @see TaskExecutorAdapter#concurrentExecutor
     */
    private final Executor concurrentExecutor;
    
    /**
     * @see TaskExecutorAdapter#submit(Runnable)
     */
    public Future<?> submit(Runnable task) {
        return null;
    }

    /**
     * @see TaskExecutorAdapter#submit(Callable) 
     */
    public <T> Future<T> submit(Callable<T> task) {
        return null;
    }
}
