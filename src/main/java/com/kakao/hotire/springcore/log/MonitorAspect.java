package com.kakao.hotire.springcore.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.Objects;
import java.util.Optional;


@Slf4j
@Aspect
@Component
public class MonitorAspect {

    interface Logger {
        void log(final String format, Object ... args);
    }

    public enum Level implements Logger {
        TRACE {
            @Override
            public void log(String format, Object... args) {
                log.trace(format, args);
            }
        }
        ,
        DEBUG {
            @Override
            public void log(String format, Object... args) { log.debug(format, args); }
        },
        INFO {
            @Override
            public void log(String format, Object... args) {
                log.info(format, args);
            }
        },
    }

    @Around("@annotation(monitor)")
    public Object monitorMethod(ProceedingJoinPoint joinPoint, Monitor monitor) throws Throwable {
        return monitor(joinPoint, monitor);
    }

    @Around("@within(monitor)")
    public Object monitorType(ProceedingJoinPoint joinPoint, Monitor monitor) throws Throwable {
        return monitor(joinPoint, monitor);
    }

    protected Optional<StopWatch> getStopWatch(Monitor monitor) {
        return monitor.timer() ? Optional.of(new StopWatch()) : Optional.empty();
    }

    protected Object monitor(ProceedingJoinPoint joinPoint, Monitor monitor) throws Throwable {
        final MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        final Optional<StopWatch> stopWatch = getStopWatch(monitor);

        stopWatch.ifPresent(StopWatch::start);

        log.info("monitor :{}", monitor);
        log.info("Monitor Start");
        log.info("method : {}", methodSignature.getMethod());

        for (Object arg : joinPoint.getArgs()) {
            if (Objects.nonNull(arg)) {
                log.info("arg type : {} value : {}", arg.getClass().getSimpleName(), arg);
            }
        }

        final Object result = joinPoint.proceed();

        stopWatch.ifPresent(StopWatch::stop);

        log.info("result : {}", result);
        stopWatch.ifPresent(it -> log.info("total elapsed time : {}", it.getTotalTimeSeconds()));
        log.info("Monitor End");

        return result;
    }

}
