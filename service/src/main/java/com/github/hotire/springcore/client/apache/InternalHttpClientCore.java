package com.github.hotire.springcore.client.apache;

import java.io.IOException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.protocol.HttpContext;

/**
 * @see org.apache.http.impl.client.InternalHttpClient;
 */
public class InternalHttpClientCore {

    /**
     * @see org.apache.http.impl.client.InternalHttpClient#doExecute(HttpHost, HttpRequest, HttpContext)
     */
    protected CloseableHttpResponse doExecute(
        final HttpHost target,
        final HttpRequest request,
        final HttpContext context) throws IOException, ClientProtocolException {
        return null;
    }

}
