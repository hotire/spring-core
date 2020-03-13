package com.kakao.hotire.springcore.argument;


import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EntityArgument {
    EntityArgumentResolver.EntityType type();
    String value() default "";
    String parameterType() default "path";
}
