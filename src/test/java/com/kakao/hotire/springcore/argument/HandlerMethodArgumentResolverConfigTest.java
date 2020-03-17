package com.kakao.hotire.springcore.argument;

import org.junit.jupiter.api.Test;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    void addArgumentResolvers() {
        // given
        final List<HandlerMethodArgumentResolver> resolvers = new ArrayList<>();
        final HandlerMethodArgumentResolverConfig config = new HandlerMethodArgumentResolverConfig();

        // when
        config.addArgumentResolvers(resolvers);

        // then
        assertThat(resolvers.size()).isEqualTo(1);
        assertThat(resolvers.get(0)).isInstanceOf(EntityArgumentResolver.class);
    }
}