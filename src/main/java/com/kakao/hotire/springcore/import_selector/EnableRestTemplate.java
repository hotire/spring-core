package com.kakao.hotire.springcore.import_selector;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(ImportRestTemplateSelector.class)
public @interface EnableRestTemplate {
  Mode mode() default Mode.NONE;
}
