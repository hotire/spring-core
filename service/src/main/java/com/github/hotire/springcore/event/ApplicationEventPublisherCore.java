package com.github.hotire.springcore.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.core.ResolvableType;

/**
 * @see org.springframework.context.ApplicationEventPublisher
 */
public class ApplicationEventPublisherCore {

    public void publishEvent(ApplicationEvent event) {
        publishEvent((Object) event);
    }

    /**
     * @see org.springframework.context.support.AbstractApplicationContext#publishEvent(Object, ResolvableType) 
     */
    void publishEvent(Object event) {
        
    }
}
