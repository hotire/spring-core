package com.github.hotire.springcore.boot;

import java.util.Set;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;

import com.github.hotire.springcore.context.CustomApplicationContextInitializer;

import lombok.extern.slf4j.Slf4j;

/**
 *  @see org.springframework.boot.SpringApplicationRunListeners;
 *  @see org.springframework.boot.context.event.EventPublishingRunListener;
 *
 *  publish Event
 */
@Slf4j
public class SpringApplicationEventListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

    @SuppressWarnings(value = { "rawtypes", "unchecked" })
    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        Set listeners = event.getSpringApplication().getInitializers();
        listeners.add(new CustomApplicationContextInitializer());
        event.getSpringApplication().setInitializers(listeners);
        log.info("SpringApplicationEventListener listen {}", event);
    }
}
