package com.github.hotire.springcore.async;

import java.io.IOException;
import jakarta.servlet.AsyncEvent;
import org.springframework.web.context.request.async.AsyncWebRequest;
import org.springframework.web.context.request.async.StandardServletAsyncWebRequest;

/**
 * @see AsyncWebRequest
 * @see StandardServletAsyncWebRequest
 */
public class AsyncWebRequestCore {

    /**
     * @see AsyncWebRequest#addTimeoutHandler(Runnable)
     * @see StandardServletAsyncWebRequest#addTimeoutHandler(Runnable)
     */
    void addTimeoutHandler(Runnable runnable) {

    }

    /**
     * @see StandardServletAsyncWebRequest#onTimeout(AsyncEvent) 
     */
    void onTimeout(AsyncEvent event) throws IOException {
    }

}
