package com.github.hotire.springcore.client.apache.execchain;

import java.io.IOException;
import org.apache.http.HttpException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpExecutionAware;
import org.apache.http.client.methods.HttpRequestWrapper;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.execchain.ClientExecChain;
import org.apache.http.impl.execchain.MinimalClientExec;

/**
 * @see MinimalClientExec
 */
public class MinimalClientExecCore {

    /**
     * @see MinimalClientExec#execute(HttpRoute, HttpRequestWrapper, HttpClientContext, HttpExecutionAware)
     */
    public CloseableHttpResponse execute(
        HttpRoute route,
        HttpRequestWrapper request,
        HttpClientContext clientContext,
        HttpExecutionAware execAware) throws IOException, HttpException {
        return null;
    }

}
