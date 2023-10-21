package com.github.hotire.springcore.client.apache;

import java.io.IOException;
import java.net.URI;
import org.apache.http.client.HttpClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

/**
 * @see HttpComponentsClientHttpRequestFactory
 */
public class HttpComponentsClientHttpRequestFactoryCore {

    private HttpClient httpClient;


    /**
     * @see HttpComponentsClientHttpRequestFactory#createRequest(URI, HttpMethod)
     */
    public ClientHttpRequest createRequest(URI uri, HttpMethod httpMethod) throws IOException {
        return null;
    }

    /**
     * @see HttpComponentsClientHttpRequestFactory#getHttpClient()
     */
    public HttpClient getHttpClient() {
        return this.httpClient;
    }

}
