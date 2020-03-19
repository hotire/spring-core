package com.kakao.hotire.springcore.argument;

import com.kakao.hotire.springcore.argument.entity.Line;
import com.kakao.hotire.springcore.argument.service.KakaoService;
import com.kakao.hotire.springcore.argument.service.LineService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.HandlerMapping;

import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.kakao.hotire.springcore.argument.EntityArgumentResolver.EntityArgumentType.LINE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.web.bind.annotation.ValueConstants.DEFAULT_NONE;

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

    @Test
    void resolveArgument() throws Exception {
        // given
        final Parameter parameter = this.getClass().getDeclaredMethod("provideParameter", Line.class).getParameters()[0];
        final NativeWebRequest request = mock(NativeWebRequest.class);
        final MethodParameter methodParameter = mock(MethodParameter.class);
        final EntityArgument entityArgument = mock(EntityArgument.class);
        final EntityArgumentResolver resolver = new EntityArgumentResolver();
        final ApplicationContext applicationContext = mock(ApplicationContext.class);
        final LineService lineService = mock(LineService.class);
        final Long id = 1L;
        final Line line = new Line(id);

        // when
        when(lineService.findById(1L)).thenReturn(line);
        when(applicationContext.getBean(KakaoService.class)).thenReturn(new KakaoService());
        when(applicationContext.getBean(LineService.class)).thenReturn(lineService);
        when(entityArgument.type()).thenReturn(LINE);
        when(entityArgument.value()).thenReturn(DEFAULT_NONE);
        when(methodParameter.getParameter()).thenReturn(parameter);
        when(methodParameter.getMethodAnnotation(EntityArgument.class)).thenReturn(entityArgument);
        when(request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE, RequestAttributes.SCOPE_REQUEST)).thenReturn(Map.of("lineId", id.toString()));
        resolver.setApplicationContext(applicationContext);
        final Object result = resolver.resolveArgument(methodParameter, mock(ModelAndViewContainer.class), request, mock(WebDataBinderFactory.class));

        // then
        Assertions.assertThat(result).isEqualTo(line);
    }

    void provideParameter(Line line) {
    }
}