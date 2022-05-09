package com.github.hotire.springcore.resource;

/**
 * @see org.springframework.boot.autoconfigure.web.WebProperties.Resources
 */
public class ResourcesCore {
    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = { "classpath:/META-INF/resources/",
                                                                   "classpath:/resources/", "classpath:/static/", "classpath:/public/" };
}
