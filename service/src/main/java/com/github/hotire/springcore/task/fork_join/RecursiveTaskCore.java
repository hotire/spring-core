package com.github.hotire.springcore.task.fork_join;

import java.util.concurrent.RecursiveTask;

/**
 * @see RecursiveTask
 */
public abstract class RecursiveTaskCore<V> {


    /**
     * @see RecursiveTask#compute()
     */
    protected abstract V compute();
}
