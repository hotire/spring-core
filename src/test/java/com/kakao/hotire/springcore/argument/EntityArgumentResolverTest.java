package com.kakao.hotire.springcore.argument;

import com.kakao.hotire.springcore.argument.service.KakaoService;
import com.kakao.hotire.springcore.argument.service.LineService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.core.MethodParameter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

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

    @Test
    void setApplicationContext() {
        // given
        final ApplicationContext applicationContext = mock(ApplicationContext.class);
        final EntityArgumentResolver entityArgumentResolver = new EntityArgumentResolver();

        // when
        when(applicationContext.getBean(KakaoService.class)).thenReturn(mock(KakaoService.class));
        when(applicationContext.getBean(LineService.class)).thenReturn(mock(LineService.class));
        entityArgumentResolver.setApplicationContext(applicationContext);

        // then
        verify(applicationContext, times(1)).getBean(KakaoService.class);
        verify(applicationContext, times(1)).getBean(LineService.class);
    }

    @Test
    void entityArgumentType() {
        // given
        final List<EntityArgumentResolver.EntityArgumentType> entityArgumentTypes = Arrays.stream(EntityArgumentResolver.EntityArgumentType.values()).collect(Collectors.toList());

        // when
        int result = entityArgumentTypes.size();

        // then
        assertThat(result).isEqualTo(2);
    }
}