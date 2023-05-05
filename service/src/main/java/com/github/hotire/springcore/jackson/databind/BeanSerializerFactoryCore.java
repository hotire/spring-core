package com.github.hotire.springcore.jackson.databind;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.BeanSerializerFactory;

/**
 * 모든 Java bean에 대한 Serializer(직렬 변환기)를 제공할 수 있는 Factory 클래스
 * @see BeanSerializerFactory
 */
public interface BeanSerializerFactoryCore {

    /**
     * @see BeanSerializerFactory#_createSerializer2(SerializerProvider, JavaType, BeanDescription, boolean)
     */
    JsonSerializer<?> _createSerializer2(SerializerProvider prov,
        JavaType type, BeanDescription beanDesc, boolean staticTyping)
        throws JsonMappingException;


    /**
     * @see BeanSerializerFactory#createSerializer(SerializerProvider, JavaType)
     */
    default JsonSerializer<Object> createSerializer(SerializerProvider prov,
        JavaType origType)
        throws JsonMappingException {
        return (JsonSerializer<Object>) _createSerializer2(prov, origType, null, false);
    }
}
