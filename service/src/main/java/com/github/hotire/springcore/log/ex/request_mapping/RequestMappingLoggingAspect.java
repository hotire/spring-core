package com.github.hotire.springcore.log.ex.request_mapping;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class RequestMappingLoggingAspect {

    @Pointcut("@within(org.springframework.stereotype.Controller)")
    public void controller() {

    }

    @Around("controller()")
    public void around(ProceedingJoinPoint joinPoint) {
        log.info("[RequestMappingLoggingAspect]");
    }
}
