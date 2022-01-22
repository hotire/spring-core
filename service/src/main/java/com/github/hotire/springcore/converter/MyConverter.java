package com.github.hotire.springcore.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @see Converter
 */
@Component
public class MyConverter implements Converter<MyConverterRequest, String> {

    public MyConverter() {
        System.out.println();
    }

    @Override
    public String convert(MyConverterRequest source) {
        return source.getName();
    }
}
