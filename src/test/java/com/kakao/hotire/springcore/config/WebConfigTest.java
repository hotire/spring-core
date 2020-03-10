package com.kakao.hotire.springcore.config;


import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.http.converter.AbstractHttpMessageConverter;

import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.mock;

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