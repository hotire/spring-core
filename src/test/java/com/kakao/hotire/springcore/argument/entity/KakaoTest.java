package com.kakao.hotire.springcore.argument.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KakaoTest {

    @Test
    void create() {
        // when then
        assertThat(new Kakao(1L)).isNotNull();
    }
}