package com.kakao.hotire.springcore.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.Objects;


@Slf4j
@Aspect
@Component
public class MonitorAspect {

    @Around("@annotation(monitor)")
    public Object monitorMethod(ProceedingJoinPoint joinPoint, Monitor monitor) throws Throwable {
        return monitor(joinPoint, monitor);
    }

    @Around("@within(monitor)")
    public Object monitorType(ProceedingJoinPoint joinPoint, Monitor monitor) throws Throwable {
        return monitor(joinPoint, monitor);
    }

    protected Object monitor(ProceedingJoinPoint joinPoint, Monitor monitor) throws Throwable {
        final MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        final StopWatch stopWatch = new StopWatch();
        stopWatch.start();


        log.info("monitor :{}", monitor);
        log.info("Monitor Start");
        log.info("method : {}", methodSignature.getMethod());

        for (Object arg : joinPoint.getArgs()) {
            if (Objects.nonNull(arg)) {
                log.info("arg type : {} value : {}", arg.getClass().getSimpleName(), arg);
            }
        }

        final Object result = joinPoint.proceed();

        stopWatch.stop();;

        log.info("result : {}", result);
        log.info("total elapsed time : {}", stopWatch.getTotalTimeSeconds());
        log.info("Monitor End");

        return result;
    }

}
