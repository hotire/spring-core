package com.github.hotire.springcore.tomcat;

import org.springframework.boot.web.embedded.tomcat.ConfigurableTomcatWebServerFactory;

/**
 * @see org.springframework.boot.autoconfigure.web.embedded.TomcatWebServerFactoryCustomizer
 */
public class TomcatWebServerFactoryCustomizerCore {

    /**
     * @see org.springframework.boot.autoconfigure.web.embedded.TomcatWebServerFactoryCustomizer#customize(ConfigurableTomcatWebServerFactory)
     */
    public void customize(ConfigurableTomcatWebServerFactory factory) {

    }

    /**
     * @see org.springframework.boot.autoconfigure.web.embedded.TomcatWebServerFactoryCustomizer#customizeMaxThreads(ConfigurableTomcatWebServerFactory, int) 
     */
    private void customizeMaxThreads(ConfigurableTomcatWebServerFactory factory, int maxThreads) {
       
    }
}
