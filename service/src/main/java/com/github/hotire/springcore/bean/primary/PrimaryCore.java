package com.github.hotire.springcore.bean.primary;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.context.annotation.Primary;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;

/**
 * @see Primary
 * @see org.springframework.context.annotation.AnnotationConfigUtils#processCommonDefinitionAnnotations(AnnotatedBeanDefinition, AnnotatedTypeMetadata)
 */
@Primary
@Component
public class PrimaryCore {

}
