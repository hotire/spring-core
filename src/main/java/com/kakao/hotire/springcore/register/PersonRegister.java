package com.kakao.hotire.springcore.register;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;


/**
 * https://javacan.tistory.com/entry/spring-at-enable-config
 *
 * http://wonwoo.ml/index.php/post/1829
 */
public class PersonRegister implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(Person.class);
        genericBeanDefinition.getPropertyValues().add("name", "tire.ho");
        beanDefinitionRegistry.registerBeanDefinition("person", genericBeanDefinition);
    }
}
