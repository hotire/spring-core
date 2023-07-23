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

    @Pointcut("@within(org.springframework.stereotype.Controller) || @within(org.springframework.web.bind.annotation.RestController)")
    public void controller() {

    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping) || @annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void requestMapping() {

    }

    @Around("controller() && requestMapping()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("[RequestMappingLoggingAspect]");
        return joinPoint.proceed();
    }
}
