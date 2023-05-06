package com.github.hotire.springcore.jackson.databind;

import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.Impl;
import com.fasterxml.jackson.databind.ser.SerializerFactory;

/**
 * @see DefaultSerializerProvider
 * @see Impl
 * @see SerializerProvider
 */
public interface SerializerProviderCore {

    /**
     * @see DefaultSerializerProvider#createInstance(SerializationConfig, SerializerFactory)
     * @see Impl#createInstance(SerializationConfig, SerializerFactory) 
     */
    DefaultSerializerProvider createInstance(SerializationConfig config,
        SerializerFactory jsf);


}
