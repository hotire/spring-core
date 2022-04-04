package com.github.hotire.springcore.client;

import java.io.IOException;
import java.net.URI;

import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;

/**
 * @see ClientHttpRequestFactory
 * @see SimpleClientHttpRequestFactory
 */
public class ClientHttpRequestFactoryCore implements ClientHttpRequestFactory {
    /**
     * @see SimpleClientHttpRequestFactory#createRequest(URI, HttpMethod) 
     */
    @Override
    public ClientHttpRequest createRequest(URI uri, HttpMethod httpMethod) throws IOException {
        return null;
    }
}
