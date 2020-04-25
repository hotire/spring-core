package com.kakao.hotire.springcore.register;

import com.google.common.collect.ImmutableMap;
import com.kakao.hotire.springcore.importSelector.Mode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.StringUtils;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;


/**
 *
 * https://javacan.tistory.com/entry/spring-at-enable-config
 * http://wonwoo.ml/index.php/post/1829
 */
@Slf4j
public class ImportRestTemplateRegister implements ImportBeanDefinitionRegistrar {
    private Map<Mode, Class[]> restTemplateMap;

    @SuppressWarnings("deprecation")
    public ImportRestTemplateRegister() {
        restTemplateMap = ImmutableMap.of(Mode.NONE, new Class[]{RestTemplate.class},
          Mode.ASYNC, new Class[]{AsyncRestTemplate.class},
          Mode.ALL, new Class[]{RestTemplate.class, AsyncRestTemplate.class});
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        Map<String, Object> metaData = annotationMetadata.getAnnotationAttributes(
          EnableRegisterRestTemplate.class.getName());
        final AnnotationAttributes attributes = AnnotationAttributes.fromMap(metaData);
        Objects.requireNonNull(attributes);

        final Mode mode = attributes.getEnum("mode");

        Arrays.stream(restTemplateMap.get(mode)).forEach(c -> {
            GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
            genericBeanDefinition.setBeanClass(c);
            log.info("{}", StringUtils.uncapitalize(c.getSimpleName()));
            beanDefinitionRegistry.registerBeanDefinition(StringUtils.uncapitalize(c.getSimpleName()), genericBeanDefinition);
        });

    }
}
