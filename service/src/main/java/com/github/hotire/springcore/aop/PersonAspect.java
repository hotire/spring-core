package com.github.hotire.springcore.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class PersonAspect {

  @Around("execution(* com.github.hotire.springcore.aop.PersonService.sayHello(..))")
  public Object logging(ProceedingJoinPoint pjp) throws Throwable {
    log.info("start - " + pjp.getSignature().getDeclaringTypeName() + " / " + pjp.getSignature().getName());
    Object result = pjp.proceed();
    log.info("finished - " + pjp.getSignature().getDeclaringTypeName() + " / " + pjp.getSignature().getName());
    return result;
  }

  @Around("execution(* com.github.hotire.springcore.aop.PersonService.*(..))")
  public Object logging3(ProceedingJoinPoint pjp) throws Throwable {
    log.info("start - " + pjp.getSignature().getDeclaringTypeName() + " / " + pjp.getSignature().getName());
    Object result = pjp.proceed();
    log.info("finished - " + pjp.getSignature().getDeclaringTypeName() + " / " + pjp.getSignature().getName());
    return result;
  }

  @Around("execution(* com.github.hotire.springcore.aop.AOPService.service(..))")
  public Object logging2(ProceedingJoinPoint pjp) throws Throwable {
    log.info("start - " + pjp.getSignature().getDeclaringTypeName() + " / " + pjp.getSignature().getName());
    Object result = pjp.proceed();
    log.info("finished - " + pjp.getSignature().getDeclaringTypeName() + " / " + pjp.getSignature().getName());
    return result;
  }
}
