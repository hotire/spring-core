package com.github.hotire.springcore.filter.response;


import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.web.util.ContentCachingResponseWrapper;

/**
 * @see ContentCachingResponseWrapper
 */
public class ContentCachingResponseWrapperCore {

    /**
     * @see ContentCachingResponseWrapper#content
     */
    private final FastByteArrayOutputStream content = new FastByteArrayOutputStream(1024);
}
