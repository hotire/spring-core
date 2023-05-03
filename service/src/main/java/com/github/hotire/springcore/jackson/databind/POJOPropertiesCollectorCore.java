package com.github.hotire.springcore.jackson.databind;

import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.POJOPropertiesCollector;
import com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @see POJOPropertiesCollector
 */
public interface POJOPropertiesCollectorCore {

    /**
     * @see POJOPropertiesCollector#getJsonValueAccessor()
     */
    AnnotatedMember getJsonValueAccessor();

    /**
     * @see POJOPropertiesCollector#collectAll()
     */
    default void collectAll() {
        final LinkedHashMap<String, POJOPropertyBuilder> props = new LinkedHashMap<String, POJOPropertyBuilder>();
        _addFields(props);
        _addMethods(props);
    }

    /**
     * @see POJOPropertiesCollector#_addFields(Map)
     */
    void _addFields(Map<String, POJOPropertyBuilder> props);

    /**
     * @see POJOPropertiesCollector#_addMethods(Map)
     */
    void _addMethods(Map<String, POJOPropertyBuilder> props);

    /**
     * @see POJOPropertiesCollector#_checkRenameByField(String) 
     */
    String _checkRenameByField(String implName);
}
