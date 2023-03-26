package com.github.hotire.springcore.async;

import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.WebAsyncManager;
import org.springframework.web.context.request.async.WebAsyncUtils;

/**
 * @see WebAsyncUtils
 */
public class WebAsyncUtilsCore {


    /**
     * @see WebAsyncUtils#getAsyncManager(WebRequest)
     */
    public static WebAsyncManager getAsyncManager(WebRequest webRequest) {
        return WebAsyncUtils.getAsyncManager(webRequest);
    }
}
