package com.github.hotire.springcore.jackson.databind;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.Impl;
import com.fasterxml.jackson.databind.ser.SerializerFactory;
import java.io.IOException;

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

    /**
     * @see DefaultSerializerProvider#serializeValue(JsonGenerator, Object)
     */
    void serializeValue(JsonGenerator gen, Object value) throws IOException;


}
