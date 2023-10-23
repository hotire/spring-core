package com.github.hotire.springcore.client.apache.conn;

import org.apache.http.conn.ConnectionRequest;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.routing.HttpRoute;

/**
 * @see HttpClientConnectionManager
 */
public interface HttpClientConnectionManagerCore {

    /** 
     * @see HttpClientConnectionManager#requestConnection(HttpRoute, Object)
     */
    ConnectionRequest requestConnection(HttpRoute route, Object state);
}
