package com.github.hotire.springcore.aop.proxy;

import org.springframework.aop.TargetSource;

/**
 * @see TargetSource
 */
public class TargetSourceCore {

    /**
     * @see
     */
    private final TargetSource targetSource = new TargetSource() {

        @Override
        public Class<?> getTargetClass() {
            return null;
        }

        @Override
        public boolean isStatic() {
            return false;
        }

        @Override
        public Object getTarget() throws Exception {
            return null;
        }

        @Override
        public void releaseTarget(Object target) throws Exception {

        }
    };
}
