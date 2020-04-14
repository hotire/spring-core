package com.kakao.hotire.springcore.log;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface Monitor {
    boolean timer() default true;
    System.Logger.Level level() default System.Logger.Level.DEBUG;
}
