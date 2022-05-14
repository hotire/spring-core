package com.github.hotire.springcore.context;

import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;

/**
 * @see org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext
 */
public class ServletWebServerApplicationContextCore {

    /***
     * @see ServletWebServerApplicationContext#onRefresh()
     */
    protected void onRefresh() {
        createWebServer();
    }

    private void createWebServer() {

    }
}
