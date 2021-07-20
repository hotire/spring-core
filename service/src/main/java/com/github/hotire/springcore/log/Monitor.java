package com.github.hotire.springcore.log;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface Monitor {
    boolean timer() default true;
    MonitorAspect.Level level() default MonitorAspect.Level.DEBUG;
}
