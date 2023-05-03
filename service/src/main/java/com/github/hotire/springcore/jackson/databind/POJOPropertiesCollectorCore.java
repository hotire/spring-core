package com.github.hotire.springcore.jackson.databind;

import com.fasterxml.jackson.databind.introspect.POJOPropertiesCollector;

/**
 * @see POJOPropertiesCollector
 */
public interface POJOPropertiesCollectorCore {

    /**
     * @see POJOPropertiesCollector#_checkRenameByField(String) 
     */
    String _checkRenameByField(String implName);
}
