package com.kakao.hotire.springcore.argument;

import org.junit.jupiter.api.Test;
import org.springframework.core.MethodParameter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class EntityArgumentResolverTest {

    @Test
    void supportsParameter() {
        // given
        final boolean expected = true;
        final MethodParameter methodParameter = mock(MethodParameter.class);
        final EntityArgumentResolver entityArgumentResolver = new EntityArgumentResolver();

        // when
        when(methodParameter.hasMethodAnnotation(EntityArgument.class)).thenReturn(expected);
        final boolean result = entityArgumentResolver.supportsParameter(methodParameter);

        // then
        assertThat(result).isEqualTo(expected);
    }

}