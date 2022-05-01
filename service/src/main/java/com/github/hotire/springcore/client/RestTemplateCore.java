package com.github.hotire.springcore.client;

import java.io.IOException;
import java.net.URI;

import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.lang.Nullable;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * @see RestTemplate
 */
public class RestTemplateCore {

    /**
     * @see RestTemplate#doExecute(URI, HttpMethod, RequestCallback, ResponseExtractor)
     */
    protected <T> T doExecute(URI url, @Nullable HttpMethod method, @Nullable RequestCallback requestCallback,
                              @Nullable ResponseExtractor<T> responseExtractor) throws RestClientException {
        return null;
    }

    /**
     * @see RestTemplate#createRequest(URI, HttpMethod) 
     */
    protected ClientHttpRequest createRequest(URI url, HttpMethod method) throws IOException {
       return null;
    }
}
