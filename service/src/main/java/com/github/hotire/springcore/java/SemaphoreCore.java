package com.github.hotire.springcore.java;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @see Semaphore
 * @see java.util.concurrent.locks.AbstractQueuedSynchronizer;
 * @see java.util.concurrent.Semaphore.Sync;
 * @see java.util.concurrent.Semaphore.FairSync;
 */
public class SemaphoreCore {

    /**
     * @see Semaphore#tryAcquire()
     */
    public boolean tryAcquire(long timeout, TimeUnit unit) {
        return true;
    }

    /**
     * @see Semaphore#release()
     */
    public void release() {
    }
}
