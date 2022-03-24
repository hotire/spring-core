package com.github.hotire.springcore.boot;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.util.ClassUtils;

import com.github.hotire.springcore.Application;

class ClassUtilsTest {

    @Test
    void getPackageName() {
        // when
        final String packageName = ClassUtils.getPackageName(Application.class);

        // then
        assertThat(packageName).isEqualTo("com.github.hotire.springcore");
    }
}
