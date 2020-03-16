package com.kakao.hotire.springcore.argument;


import org.springframework.web.bind.annotation.ValueConstants;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EntityArgument {
    EntityArgumentResolver.EntityArgumentType type();
    String value() default ValueConstants.DEFAULT_NONE;
    String parameterType() default "path";
}
