package com.kakao.hotire.springcore.argument;

import org.junit.jupiter.api.Test;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;

import static org.assertj.core.api.Assertions.assertThat;

class HandlerMethodArgumentResolverConfigTest {

    @Test
    void entityArgumentResolver() {
        // given
        final HandlerMethodArgumentResolverConfig config = new HandlerMethodArgumentResolverConfig();

        // when
        final EntityArgumentResolver entityArgumentResolver = config.entityArgumentResolver();

        // then
        assertThat(entityArgumentResolver).isInstanceOf(HandlerMethodArgumentResolver.class);
    }
}