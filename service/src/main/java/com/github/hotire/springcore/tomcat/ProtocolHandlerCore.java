package com.github.hotire.springcore.tomcat;

import java.lang.reflect.InvocationTargetException;

import org.apache.coyote.ProtocolHandler;

/**
 * @see org.apache.coyote.ProtocolHandler
 * @see org.apache.coyote.AbstractProtocol
 */
public class ProtocolHandlerCore {

    /**
     * @see org.apache.coyote.AbstractProtocol#setMaxThreads(int)
     */
    public void setMaxThreads(int maxThreads) {

    }

    /**
     * @see org.apache.coyote.ProtocolHandler#create(String)
     */
    public static ProtocolHandler create(String protocol) throws ClassNotFoundException, InvocationTargetException, InstantiationException, NoSuchMethodException, IllegalAccessException {
        return ProtocolHandler.create(protocol);
    }
}
