package com.github.hotire.springcore.test;

import com.github.hotire.springcore.exception.ExceptionHandlerController;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MockMvcBuildersUtils {
    public static MockMvc mockMvc(Object... controllers) {
        return MockMvcBuilders
            .standaloneSetup(controllers)
            .setConversionService(conversionService())
            .setControllerAdvice(new ExceptionHandlerController(new DefaultErrorAttributes()))
            .build();
    }

    public static FormattingConversionService conversionService() {
        final DateTimeFormatterRegistrar registrar = new DateTimeFormatterRegistrar();
        final FormattingConversionService conversion = new DefaultFormattingConversionService();
        registrar.setUseIsoFormat(true);
        registrar.registerFormatters(conversion);
        return conversion;
    }
}
