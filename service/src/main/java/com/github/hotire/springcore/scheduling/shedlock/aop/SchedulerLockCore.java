package com.github.hotire.springcore.scheduling.shedlock.aop;

import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;

/**
 * @see SchedulerLock
 */
public @interface SchedulerLockCore {

    String lockAtMostFor() default "";
}
