package com.github.hotire.springcore.context;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

import lombok.extern.slf4j.Slf4j;

/**
 * @see org.springframework.boot.SpringApplication#applyInitializers(ConfigurableApplicationContext)
 * ->
 * @see org.springframework.boot.SpringApplication#prepareContext
 *
 * 	listeners.contextPrepared(context); 이전에 applyInitializers 호출된다.
 */
@Slf4j
public class CustomApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        log.info("CustomApplicationContextInitializer : {}", applicationContext);
    }
}
