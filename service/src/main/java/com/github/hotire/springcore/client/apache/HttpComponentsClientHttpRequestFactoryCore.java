package com.github.hotire.springcore.client.apache;

import org.apache.http.client.HttpClient;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

/**
 * @see HttpComponentsClientHttpRequestFactory
 */
public class HttpComponentsClientHttpRequestFactoryCore {

    private HttpClient httpClient;


    /**
     * @see HttpComponentsClientHttpRequestFactory#getHttpClient()
     */
    public HttpClient getHttpClient() {
        return this.httpClient;
    }

}
