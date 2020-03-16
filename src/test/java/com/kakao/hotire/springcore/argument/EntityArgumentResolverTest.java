package com.kakao.hotire.springcore.argument;

import com.kakao.hotire.springcore.argument.service.KakaoService;
import com.kakao.hotire.springcore.argument.service.LineService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.core.MethodParameter;

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

}