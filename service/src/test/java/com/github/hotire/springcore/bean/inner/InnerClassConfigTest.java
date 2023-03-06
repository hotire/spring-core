package com.github.hotire.springcore.bean.inner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.github.hotire.springcore.bean.inner.InnerClassConfig.Inner;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.Test;

class InnerClassConfigTest {

    @Test
    void create() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        // given
        final InnerClassConfig config = new InnerClassConfig();
        final Constructor<?>[] constructors = Inner.class.getDeclaredConstructors();
        final Constructor<?> constructor = constructors[0];

        // when
        final Class<?> parameterType = constructor.getParameters()[0].getType();
        final Object result = constructor.newInstance(config);

        // then
        assertThat(result).isInstanceOf(Inner.class);
        assertThat(parameterType).isEqualTo(InnerClassConfig.class);
    }
}