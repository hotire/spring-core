package com.github.hotire.springcore.client;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;

/**
 * @see ClientHttpRequest
 * @see org.springframework.http.client.SimpleBufferingClientHttpRequest
 */
public class ClientHttpRequestCore implements ClientHttpRequest {

    @Override
    public ClientHttpResponse execute() throws IOException {
        return null;
    }

    @Override
    public OutputStream getBody() throws IOException {
        return null;
    }

    @Override
    public String getMethodValue() {
        return null;
    }

    @Override
    public URI getURI() {
        return null;
    }

    @Override
    public HttpHeaders getHeaders() {
        return null;
    }
}
