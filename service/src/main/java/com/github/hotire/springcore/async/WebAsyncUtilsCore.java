package com.github.hotire.springcore.async;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.AsyncWebRequest;
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

    /**
     * @see WebAsyncUtils#createAsyncWebRequest(HttpServletRequest, HttpServletResponse)
     */
    public static AsyncWebRequest createAsyncWebRequest(HttpServletRequest request, HttpServletResponse response) {
        return WebAsyncUtils.createAsyncWebRequest(request, response);
    }
}
