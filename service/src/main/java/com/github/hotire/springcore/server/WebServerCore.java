package com.github.hotire.springcore.server;

import java.util.Map;

import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.server.WebServerException;

/**
 * @see org.springframework.boot.web.server.WebServer
 * @see org.springframework.boot.web.embedded.tomcat.TomcatWebServer
 */
public class WebServerCore {

    /**
     * @see org.springframework.context.support.DefaultLifecycleProcessor#doStart(Map, String, boolean)
     * @see WebServer#start()
     */
    public void start() throws WebServerException {

    }
}
