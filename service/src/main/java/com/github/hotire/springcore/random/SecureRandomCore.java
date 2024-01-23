package com.github.hotire.springcore.random;

import java.security.SecureRandom;
import java.security.SecureRandomSpi;

/**
 * @see SecureRandom
 */
public class SecureRandomCore {

    /**
     * @see SecureRandom#secureRandomSpi
     */
    private SecureRandomSpi secureRandomSpi;

    private boolean threadSafe;


    /**
     * @see SecureRandom#nextInt(int)
     */
    public int nextInt(int bound) {
        return next(31);
    }

    /**
     * @see SecureRandom#next(int)
     */
    protected final int next(int numBits) {
        int numBytes = (numBits+7)/8;
        byte[] b = new byte[numBytes];
        nextBytes(b);
        return 0;
    }

    /**
     * @see SecureRandom#nextBytes(byte[])
     * @see SecureRandomSpi#engineNextBytes(byte[]) 
     */
    public void nextBytes(byte[] bytes) {
        if (threadSafe) {
//            secureRandomSpi.engineNextBytes(bytes);
        } else {
            synchronized (this) {
//                secureRandomSpi.engineNextBytes(bytes);
            }
        }
    }
}
