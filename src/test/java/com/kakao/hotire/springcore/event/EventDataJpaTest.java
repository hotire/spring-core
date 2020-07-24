package com.kakao.hotire.springcore.event;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
//@DataJpaTest
public @interface EventDataJpaTest {

    @AliasFor(annotation = DataJpaTest.class)
    String[] properties() default {};

    @AliasFor(annotation = DataJpaTest.class)
    boolean showSql() default true;

    @AliasFor(annotation = DataJpaTest.class)
    boolean useDefaultFilters() default true;

    @AliasFor(annotation = DataJpaTest.class)
    ComponentScan.Filter[] includeFilters() default { @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EventComponent.class)};

    @AliasFor(annotation = DataJpaTest.class)
    ComponentScan.Filter[] excludeFilters() default {};

    @AliasFor(annotation = DataJpaTest.class)
    Class<?>[] excludeAutoConfiguration() default {};
}
