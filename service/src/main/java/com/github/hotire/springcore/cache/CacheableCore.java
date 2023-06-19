package com.github.hotire.springcore.cache;

import org.springframework.cache.annotation.Cacheable;

/**
 * @see Cacheable
 */
public @interface CacheableCore {


    /***
     * @see Cacheable#unless()
     */
    String unless() default "";
}
