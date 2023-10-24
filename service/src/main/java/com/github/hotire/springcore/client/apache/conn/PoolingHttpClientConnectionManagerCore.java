package com.github.hotire.springcore.client.apache.conn;

import org.apache.http.conn.ConnectionRequest;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

/**
 * @see PoolingHttpClientConnectionManager
 */
public class PoolingHttpClientConnectionManagerCore {


    /**
     * @see PoolingHttpClientConnectionManager#requestConnection(HttpRoute, Object)
     */
    public ConnectionRequest requestConnection(HttpRoute route, Object state) {
        return null;
    }
}
