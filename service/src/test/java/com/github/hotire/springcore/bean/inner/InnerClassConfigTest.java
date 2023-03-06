package com.github.hotire.springcore.bean.inner;

import com.github.hotire.springcore.bean.inner.InnerClassConfig.Inner;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.Test;

class InnerClassConfigTest {

    @Test
    void create() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        final InnerClassConfig config = new InnerClassConfig();
        final Constructor<?>[] constructors = Inner.class.getDeclaredConstructors();
        constructors[0].newInstance(config);
    }
}