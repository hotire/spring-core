package com.github.hotire.springcore.concurrent.executor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @see BlockingQueue
 * @see LinkedBlockingQueue
 */
public class BlockingQueueCore<E> {

    /**
     * @see BlockingQueue#poll(long, TimeUnit) 
     * @see LinkedBlockingQueue#poll(long, TimeUnit) 
     */
    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        return null;
    }

    /**
     * @see LinkedBlockingQueue#take()
     */
    public E take() throws InterruptedException {
        return null;
    }
}
