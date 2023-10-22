package com.github.hotire.springcore.client.apache;


import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpResponse;

/**
 * @see org.springframework.http.client.HttpComponentsClientHttpRequest
 */
@RequiredArgsConstructor
public class HttpComponentsClientHttpRequestCore {

    private final HttpClient httpClient;

    private final HttpUriRequest httpRequest;

    private final HttpContext httpContext;

    /**
     * @see org.springframework.http.client.HttpComponentsClientHttpRequest#executeInternal(HttpHeaders, byte[])
     */
    protected ClientHttpResponse executeInternal(HttpHeaders headers, byte[] bufferedOutput) throws IOException {
        HttpResponse httpResponse = this.httpClient.execute(this.httpRequest, this.httpContext);
        return null;
    }
}
