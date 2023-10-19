package com.github.hotire.springcore.client.apache;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.Configurable;

/**
 * @see Configurable
 */
public interface ConfigurableCore {

    /**
     * @see Configurable#getConfig()
     */
    RequestConfig getConfig();
}
