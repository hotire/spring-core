package com.github.hotire.springcore.tomcat.catalina;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.connector.Connector;
import org.apache.coyote.ProtocolHandler;

/**
 * @see Connector
 */
@RequiredArgsConstructor
public class ConnectorCore {
    protected final ProtocolHandler protocolHandler;
}
