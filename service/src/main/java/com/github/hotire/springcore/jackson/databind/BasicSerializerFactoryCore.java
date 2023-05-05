package com.github.hotire.springcore.jackson.databind;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.BasicSerializerFactory;

/**
 * @see BasicSerializerFactory
 */
public interface BasicSerializerFactoryCore {

    /**
     * @see BasicSerializerFactory#findSerializerByAnnotations(SerializerProvider, JavaType, BeanDescription) 
     */
    JsonSerializer<?> findSerializerByAnnotations(SerializerProvider prov,
        JavaType type, BeanDescription beanDesc)
        throws JsonMappingException;
}
