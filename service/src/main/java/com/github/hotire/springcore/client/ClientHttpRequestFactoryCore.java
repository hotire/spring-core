package com.github.hotire.springcore.client;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;

import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

/**
 * @see ClientHttpRequestFactory
 * @see SimpleClientHttpRequestFactory
 * @see HttpComponentsClientHttpRequestFactory
 */
public class ClientHttpRequestFactoryCore implements ClientHttpRequestFactory {
    /**
     * @see SimpleClientHttpRequestFactory#createRequest(URI, HttpMethod)
     */
    @Override
    public ClientHttpRequest createRequest(URI uri, HttpMethod httpMethod) throws IOException {
        return null;
    }

    /**
     * @see SimpleClientHttpRequestFactory#prepareConnection(HttpURLConnection, String)
     */
    protected void prepareConnection(HttpURLConnection connection, String httpMethod) throws IOException {

    }
}
