package com.github.hotire.springcore.tomcat.ex;

import org.apache.coyote.AbstractProtocol;
import org.apache.tomcat.util.IntrospectionUtils;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;

/**
 * @see WebServerFactoryCustomizer
 * @see TomcatServletWebServerFactory
 */
public class TomcatWebServerFactoryCustomizer implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {

    /**
     * @see AbstractProtocol
     * @see IntrospectionUtils#setProperty(Object, String, String, boolean, StringBuilder) 
     */
    @Override
    public void customize(TomcatServletWebServerFactory factory) {
        factory.addConnectorCustomizers(connector -> {
            connector.setProperty("maxThread", "200");
        });
    }
}
