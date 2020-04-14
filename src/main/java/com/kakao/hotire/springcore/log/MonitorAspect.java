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

    final StopWatch stopWatch = new StopWatch();

    @Around("@annotation(Monitor) || @within(Monitor)")
    public Object monitor(ProceedingJoinPoint joinPoint) throws Throwable {
        final MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        stopWatch.start();

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
