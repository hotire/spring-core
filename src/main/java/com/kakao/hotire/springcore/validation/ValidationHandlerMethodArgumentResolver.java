package com.kakao.hotire.springcore.validation;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.annotation.ModelFactory;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.kakao.hotire.springcore.validation.Validation.Entry;

public class ValidationHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    private static final String DEFAULT_PARAMETER = "validation";
    private static final String DEFAULT_DELIMITER = ",";

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return Validation.class.equals(methodParameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        String[] searchParameter = nativeWebRequest.getParameterValues(DEFAULT_PARAMETER);
        String name = ModelFactory.getNameForParameter(methodParameter);

        final Validation validation = Optional.ofNullable(searchParameter)
                                              .map(this::parseSearch)
                                              .orElse(new Validation());

        WebDataBinder binder = webDataBinderFactory.createBinder(nativeWebRequest, validation, name);

        binder.validate();

        if (binder.getBindingResult().hasErrors()) {
            throw new IllegalArgumentException(binder.getBindingResult().getAllErrors()
                                                     .stream()
                                                     .map(DefaultMessageSourceResolvable::getDefaultMessage)
                                                     .collect(Collectors.joining())
            );
        }
        return validation;
    }

    private Validation parseSearch(String[] searchParameter) {
        Set<Entry> entrySet = Arrays.stream(searchParameter)
                                    .map(str -> str.split(DEFAULT_DELIMITER, 2))
                                    .filter(pair -> pair.length == 2 && !pair[1].isEmpty())
                                    .map(pair -> new Entry(pair[0], pair[1]))
                                    .collect(Collectors.toSet());
        return new Validation(entrySet, "");
    }
}
