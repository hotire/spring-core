package com.github.hotire.springcore.argument;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.web.bind.annotation.ValueConstants;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EntityArgument {
    EntityArgumentResolver.EntityArgumentType type();
    String value() default ValueConstants.DEFAULT_NONE;
    String parameterType() default "path";
}
