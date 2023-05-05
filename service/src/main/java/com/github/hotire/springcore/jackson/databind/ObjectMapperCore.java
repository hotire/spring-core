package com.github.hotire.springcore.jackson.databind;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.io.SegmentedStringWriter;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.ser.SerializerFactory;
import java.io.IOException;
import java.io.Writer;

/**
 * @see ObjectMapper
 */
public class ObjectMapperCore {

    protected SerializationConfig _serializationConfig;
    protected DefaultSerializerProvider _serializerProvider;

    protected SerializerFactory _serializerFactory;

    protected JsonFactory _jsonFactory;

    /**
     * @see ObjectMapper#writeValueAsString(Object)
     */
    public String writeValueAsString(Object value)
        throws JsonProcessingException {
        SegmentedStringWriter sw = new SegmentedStringWriter(_jsonFactory._getBufferRecycler());
        try {
            _writeValueAndClose(createGenerator(sw), value);
        } catch (JsonProcessingException e) {
            throw e;
        } catch (IOException e) { // shouldn't really happen, but is declared as possibility so:
            throw JsonMappingException.fromUnexpectedIOE(e);
        }
        return sw.getAndClear();
    }

    /**
     * @see ObjectMapper#createGenerator(Writer) 
     */
    public JsonGenerator createGenerator(Writer w) throws IOException {
        JsonGenerator g = _jsonFactory.createGenerator(w);
        _serializationConfig.initialize(g);
        return g;
    }
    
    /**
     * @see ObjectMapper#_writeValueAndClose(JsonGenerator, Object)
     */
    protected final void _writeValueAndClose(JsonGenerator g, Object value)
        throws IOException {
        _serializerProvider(_serializationConfig).serializeValue(g, value);
    }

    /**
     * @see ObjectMapper#_serializerProvider(SerializationConfig)
     */
    protected DefaultSerializerProvider _serializerProvider(SerializationConfig config) {
        return _serializerProvider.createInstance(config, _serializerFactory);
    }

}
