package com.kakao.hotire.springcore.argument;

import org.junit.jupiter.api.Test;
import springfox.documentation.spi.DocumentationType;

import static org.assertj.core.api.Assertions.assertThat;

class EntityArgumentParameterBuilderPluginTest {

    @Test
    void supports() {
        // given
        final boolean expected = true;
        final DocumentationType type = DocumentationType.SWAGGER_12;
        final EntityArgumentParameterBuilderPlugin plugin = new EntityArgumentParameterBuilderPlugin();

        // when
        final boolean result = plugin.supports(type);

        // then
        assertThat(result).isEqualTo(expected);
    }
}