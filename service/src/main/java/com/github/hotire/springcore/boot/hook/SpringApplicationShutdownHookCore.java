package com.github.hotire.springcore.boot.hook;

import java.security.AccessControlException;

/**
 * @see org.springframework.boot.SpringApplicationShutdownHook
 */
public class SpringApplicationShutdownHookCore implements Runnable {

    /**
     * @see org.springframework.boot.SpringApplicationShutdownHook#addRuntimeShutdownHook()
     */
    void addRuntimeShutdownHook() {
        try {
            Runtime.getRuntime().addShutdownHook(new Thread(this, "SpringApplicationShutdownHook"));
        }
        catch (AccessControlException ex) {
            // Not allowed in some environments
        }
    }

    /**
     * @see org.springframework.boot.SpringApplicationShutdownHook#run()
     */
    @Override
    public void run() {

    }
}
