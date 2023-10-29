package com.github.hotire.springcore.client.apache.conn;

import lombok.RequiredArgsConstructor;
import org.apache.http.conn.ConnectionRequest;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

/**
 * @see PoolingHttpClientConnectionManager
 */
@RequiredArgsConstructor
public class PoolingHttpClientConnectionManagerCore {

    private final CPoolCore pool;


    /**
     * @see PoolingHttpClientConnectionManager#requestConnection(HttpRoute, Object)
     */
    public ConnectionRequest requestConnection(HttpRoute route, Object state) {
        return null;
    }
}
