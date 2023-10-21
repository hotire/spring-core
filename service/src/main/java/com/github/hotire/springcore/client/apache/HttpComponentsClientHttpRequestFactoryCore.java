package com.github.hotire.springcore.client.apache;

import java.io.IOException;
import java.net.URI;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.Configurable;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.lang.Nullable;

/**
 * @see HttpComponentsClientHttpRequestFactory
 */
public class HttpComponentsClientHttpRequestFactoryCore {

    private HttpClient httpClient;

    @Nullable
    private RequestConfig requestConfig;


    /**
     * @see HttpComponentsClientHttpRequestFactory#createRequest(URI, HttpMethod)
     */
    public ClientHttpRequest createRequest(URI uri, HttpMethod httpMethod) throws IOException {
        HttpClient client = getHttpClient();
        RequestConfig config = createRequestConfig(client);
//        return new HttpComponentsClientHttpRequest(client, httpRequest, context);
        return null;
    }

    /**
     * @see HttpComponentsClientHttpRequestFactory#createRequestConfig(Object) 
     */
    protected RequestConfig createRequestConfig(Object client) {
        if (client instanceof Configurable) {
            RequestConfig clientRequestConfig = ((Configurable) client).getConfig();
//            return mergeRequestConfig(clientRequestConfig);
            return clientRequestConfig;
        }
        return this.requestConfig;
    }

    /**
     * @see HttpComponentsClientHttpRequestFactory#getHttpClient()
     */
    public HttpClient getHttpClient() {
        return this.httpClient;
    }

}
