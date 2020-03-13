package com.kakao.hotire.springcore.argument;

import com.kakao.hotire.springcore.argument.entity.Entity;
import com.kakao.hotire.springcore.argument.service.KakaoService;
import com.kakao.hotire.springcore.argument.service.LineService;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.function.Function;

import static com.kakao.hotire.springcore.argument.EntityArgumentResolver.EntityType.KAKAO;
import static com.kakao.hotire.springcore.argument.EntityArgumentResolver.EntityType.LINE;

public class EntityArgumentResolver implements HandlerMethodArgumentResolver, ApplicationContextAware {

    public enum EntityType {
        KAKAO,
        LINE;
        @Getter(AccessLevel.PRIVATE)
        @Setter(AccessLevel.PRIVATE)
        public Function<Long, Entity> function ;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        final KakaoService kakaoService = applicationContext.getBean(KakaoService.class);
        final LineService lineService = applicationContext.getBean(LineService.class);

        KAKAO.setFunction(kakaoService::findById);
        LINE.setFunction(lineService::findById);
    }

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.hasMethodAnnotation(EntityArgument.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        // TODO Implement
        return null;
    }
}
