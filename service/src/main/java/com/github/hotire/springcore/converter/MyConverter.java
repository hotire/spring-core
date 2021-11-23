package com.github.hotire.springcore.converter;

import org.springframework.core.convert.converter.Converter;

/**
 * @see Converter
 */
public class MyConverter implements Converter<MyConverterRequest, String> {
    
    @Override
    public String convert(MyConverterRequest source) {
        return source.getName();
    }
}
