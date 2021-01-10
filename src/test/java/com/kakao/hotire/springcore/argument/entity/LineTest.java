package com.kakao.hotire.springcore.argument.entity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    void create() {
        // when then
        assertThat(new Line(1L)).isNotNull();
    }
}