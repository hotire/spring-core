package com.kakao.hotire.springcore.log;

import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface Monitor {
    boolean timer() default true;
    System.Logger.Level level() default System.Logger.Level.DEBUG;
}
