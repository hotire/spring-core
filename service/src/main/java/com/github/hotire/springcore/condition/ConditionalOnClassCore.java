package com.github.hotire.springcore.condition;

import  org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;
import org.springframework.asm.ClassReader;

/**
 * @see ConditionalOnClass
 * @see Configuration
 * @see ClassReader
 * - ASM (a bytecode manipulation library)
 * 1. @Configuration 는 org.springframework.asm.ClassReader 를 통해서 jvm class load 하기전에 parsing
 * 2. ClassReader 를 사용하면 로드하지 않고 Annoation 정보를 알 수 있음
 * 3. Annoation 정보를 바탕으로 AnnotatedTypeMetadata 의 구현체 SimpleAnnotationMetadata 로 만들어져 OnClassCondition 판단
 *
 * -> Class Config 에 ConditionalOnClass 사용시 class를 로드하기 전에 판단하기 때문에 문제가 없음
 * @see org.springframework.boot.autoconfigure.condition.FilteringSpringBootCondition 구현체를 보면 isPresent try-cath 잡혀이기 때문에 문제 없이 조건 판단을 합니당.
 *
 *
 * 문제는 Configuration 를 cglib으로 감아 Enhancer 만드는 도중 연관 클래스를 로드
 * 당연히 메서드 return type도 같이 로드
 * 로드하는 부분은 try-catch 가 걸려있지 않기 때문에 ClassNotFoundException 에러가 발생
 * Class 자체를 ConditionalOnClass 붙여서 로드하지 않았다면 Enhancer 만들 필요가 없기에 에러가 발생할수 없고
 * method에 붙였다면 Enhancer로 만들어야하기 때문에 에러가 발생
 */
public class ConditionalOnClassCore {

}
