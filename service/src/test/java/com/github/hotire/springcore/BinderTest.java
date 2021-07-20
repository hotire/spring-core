package com.github.hotire.springcore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.core.env.Environment;
import org.springframework.web.context.support.StandardServletEnvironment;

class BinderTest {

    @Test
    void bind() {
        // given
        final String name = "bind";
        final String expected = "result";
        System.setProperty(name, expected);
        final Environment environment = new StandardServletEnvironment();
        final Binder binder = Binder.get(environment);

        // when
        final String bindResult = binder.bind(name, String.class).orElseThrow(IllegalStateException::new);

        // then
        assertThat(bindResult).isEqualTo(expected);
    }
}
