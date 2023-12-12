package com.github.hotire.springcore.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @see Condition
 */
public class ConditionCore {

    /**
     * @see Condition#matches(ConditionContext, AnnotatedTypeMetadata)
     */
    boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return false;
    }
}
