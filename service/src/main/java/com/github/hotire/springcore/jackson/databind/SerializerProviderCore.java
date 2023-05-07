package com.github.hotire.springcore.jackson.databind;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.PropertyName;
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


    /**
     * @see DefaultSerializerProvider#_serialize(JsonGenerator, Object, JsonSerializer, PropertyName) 
     */
    void _serialize(JsonGenerator gen, Object value,
        JsonSerializer<Object> ser, PropertyName rootName)
        throws IOException;
}
