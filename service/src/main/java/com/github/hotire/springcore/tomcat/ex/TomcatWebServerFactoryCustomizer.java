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
     * @see AbstractProtocol#setMaxThreads(int)
     * @see AbstractProtocol#setMinSpareThreads(int)
     */
    @Override
    public void customize(TomcatServletWebServerFactory factory) {
        factory.addConnectorCustomizers(connector -> {
            connector.setProperty("maxThreads", "200");
            connector.setProperty("minSpareThreads", "200");
        });
    }
}
