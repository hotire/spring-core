package com.kakao.hotire.springcore.property;

import javax.annotation.PostConstruct;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@ConstructorBinding
@ConfigurationProperties(prefix = "application")
@RequiredArgsConstructor
@Slf4j
@Getter
@ToString
public class ConstructorBindingProperties {
    private final String name;
    private final UserProperties user;

    @PostConstruct
    public void init() {
        log.info("ConstructorBindingProperties : {}", this);
    }

    @Getter
    @ToString
    @RequiredArgsConstructor
    public static class UserProperties {
        private final String name;
    }
}
