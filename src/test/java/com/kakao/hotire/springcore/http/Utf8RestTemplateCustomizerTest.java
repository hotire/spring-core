package com.kakao.hotire.springcore.http;


import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class Utf8RestTemplateCustomizerTest {

    @Test
    void customize() {
        // given
        final ArgumentCaptor<Charset> argumentCaptor = ArgumentCaptor.forClass(Charset.class);
        final AbstractHttpMessageConverter<?> converter = mock(AbstractHttpMessageConverter.class);
        final RestTemplate restTemplate = mock(RestTemplate.class);
        final Utf8RestTemplateCustomizer customizer = new Utf8RestTemplateCustomizer();

        // when
        when(restTemplate.getMessageConverters()).thenReturn(Lists.newArrayList(converter));
        customizer.customize(restTemplate);

        // then
        verify(converter, times(1)).setDefaultCharset(argumentCaptor.capture());
        assertThat(argumentCaptor.getValue()).isEqualTo(StandardCharsets.UTF_8);
    }
}