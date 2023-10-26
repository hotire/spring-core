package com.github.hotire.springcore.client.apache.execchain;

import java.io.IOException;
import org.apache.http.HttpException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpExecutionAware;
import org.apache.http.client.methods.HttpRequestWrapper;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.execchain.ClientExecChain;

/**
 * @see ClientExecChain
 */
public interface ClientExecChainCore {

    /**
     * @see ClientExecChain#execute(HttpRoute, HttpRequestWrapper, HttpClientContext, HttpExecutionAware) 
     */
    CloseableHttpResponse execute(
        HttpRoute route,
        HttpRequestWrapper request,
        HttpClientContext clientContext,
        HttpExecutionAware execAware) throws IOException, HttpException;

}
