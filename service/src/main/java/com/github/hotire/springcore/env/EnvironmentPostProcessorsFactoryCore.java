package com.github.hotire.springcore.env;

import org.springframework.boot.env.EnvironmentPostProcessorsFactory;

/**
 * @see EnvironmentPostProcessorsFactory
 */
public class EnvironmentPostProcessorsFactoryCore {

    /**
     * @see EnvironmentPostProcessorsFactory#fromSpringFactories(ClassLoader)
     * EnvironmentPostProcessorApplicationListener 생성시 해당 메서스를 통해 EnvironmentPostProcessor 구현체를 load 한다.
     */
    static EnvironmentPostProcessorsFactory fromSpringFactories(ClassLoader classLoader) {
        return null;
    }
}
