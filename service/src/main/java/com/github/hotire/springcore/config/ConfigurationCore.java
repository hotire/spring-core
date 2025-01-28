package com.github.hotire.springcore.config;

import org.springframework.context.annotation.Configuration;

/**
 * @see Configuration
 * - ASM (a bytecode manipulation library)
 * 1. @Configuration 는 org.springframework.asm.ClassReader 를 통해서 jvm class load 하기전에 parsing
 * 2. ClassReader 를 사용하면 로드하지 않고 Annoation 정보를 알 수 있음
 * 3. Annoation 정보를 바탕으로 AnnotatedTypeMetadata 의 구현체 SimpleAnnotationMetadata 로 만들어져 OnClassCondition 판단
 *
 * -> Class Config 에 ConditionalOnClass 사용시 class를 로드하기 전에 판단하기 때문에 문제가 없음
 */
public class ConfigurationCore {

}
