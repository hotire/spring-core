package com.kakao.hotire.springcore.config;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(OnMissingProfile.class)
public @interface ConditionalOnMissingProfile {
    String[] value();
}
