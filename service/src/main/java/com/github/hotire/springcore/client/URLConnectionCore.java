package com.github.hotire.springcore.client;

import java.net.ProtocolException;

/**
 * @see java.net.URLConnection
 * @see java.net.HttpURLConnection
 */
public class URLConnectionCore {

    private static final String[] methods = {
            "GET", "POST", "HEAD", "OPTIONS", "PUT", "DELETE", "TRACE"
    };

    /**
     * @see java.net.HttpURLConnection#setRequestMethod(String)
     */
    public void setRequestMethod(String method) throws ProtocolException {

    }
}
