package com.kakao.hotire.springcore.argument.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    void create() {
        // when then
        assertThat(new Line(1L)).isNotNull();
    }
}