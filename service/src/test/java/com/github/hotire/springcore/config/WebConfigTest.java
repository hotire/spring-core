package com.github.hotire.springcore.config;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.mock;

import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;
import org.springframework.http.converter.AbstractHttpMessageConverter;

import com.google.common.collect.Lists;

class WebConfigTest {

    @Test
    void configureMessageConverters() {
        // given
        final AbstractHttpMessageConverter<?> converter = mock(AbstractHttpMessageConverter.class);
        final WebConfig webConfig = new WebConfig();

        // when
        webConfig.configureMessageConverters(Lists.newArrayList(converter));

        // then
        assertThat(converter.getDefaultCharset()).isEqualTo(StandardCharsets.UTF_8);
    }
}