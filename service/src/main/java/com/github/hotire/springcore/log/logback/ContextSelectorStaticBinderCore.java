package com.github.hotire.springcore.log.logback;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.selector.ContextSelector;
import ch.qos.logback.classic.util.ContextSelectorStaticBinder;
import java.lang.reflect.InvocationTargetException;

/**
 * @see ContextSelectorStaticBinder
 */
public class ContextSelectorStaticBinderCore {

    /**
     * @see ContextSelectorStaticBinder#contextSelector
     */
    ContextSelector contextSelector;

    /**
     * @see ContextSelectorStaticBinder#init(LoggerContext, Object)
     */
    public void init(LoggerContext defaultLoggerContext, Object key) throws ClassNotFoundException, NoSuchMethodException, InstantiationException,
        IllegalAccessException, InvocationTargetException {
    }

}
