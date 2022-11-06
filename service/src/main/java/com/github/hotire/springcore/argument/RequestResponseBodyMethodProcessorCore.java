package com.github.hotire.springcore.argument;

import java.util.Collection;
import java.util.Optional;
import org.springframework.core.MethodParameter;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

/**
 * @see RequestResponseBodyMethodProcessor
 */
public class RequestResponseBodyMethodProcessorCore {

    /**
     * @see RequestResponseBodyMethodProcessor#adaptArgumentIfNecessary(Object, MethodParameter)
     */
    protected Object adaptArgumentIfNecessary(@Nullable Object arg, MethodParameter parameter) {
        if (parameter.getParameterType() == Optional.class) {
            if (arg == null || (arg instanceof Collection && ((Collection<?>) arg).isEmpty()) ||
                (arg instanceof Object[] && ((Object[]) arg).length == 0)) {
                return Optional.empty();
            }
            else {
                return Optional.of(arg);
            }
        }
        return arg;
    }
}
