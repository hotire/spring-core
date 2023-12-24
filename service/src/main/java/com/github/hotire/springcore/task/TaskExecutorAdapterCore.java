package com.github.hotire.springcore.task;

import java.util.concurrent.Executor;
import lombok.RequiredArgsConstructor;
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

}
