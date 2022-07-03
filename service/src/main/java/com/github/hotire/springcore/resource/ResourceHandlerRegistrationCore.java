package com.github.hotire.springcore.resource;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

/**
 * @see ResourceHandlerRegistration
 */
public class ResourceHandlerRegistrationCore {

    /**
     * @see ResourceHandlerRegistration#addResourceLocations(String...)
     */
    public ResourceHandlerRegistration addResourceLocations(String... locations) {
        return null;
    }

    /**
     * @see ResourceHandlerRegistration#getRequestHandler()
     */
    protected ResourceHttpRequestHandler getRequestHandler() {
        return null;
    }
}
