package com.github.hotire.springcore.random;

import java.security.PrivilegedAction;
import java.security.AccessController;


/**
 * @see PrivilegedAction
 * @see AccessController
 */
public interface PrivilegedActionCore<T> {

    /**
     * @see AccessController#doPrivileged(PrivilegedAction) 
     */
    T run();
}
