package com.github.hotire.springcore.bean.register.post_processor.config;

import java.io.IOException;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.Predicate;

import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.MethodMetadata;

/**
 * @see org.springframework.context.annotation.ConfigurationClassParser;
 *
 * Configuration 분석한다.
 *
 * ImportSelector / ImportBeanDefinitionRegistrar 처리
 * @Bean 처리
 *
 */
public class ConfigurationClassParserCore {

    /**
     * @see org.springframework.context.annotation.ConfigurationClassParser#parse(Set) 
     */
    public void parse(Set<BeanDefinitionHolder> configCandidates) {
        
    }

    /**
     * @see org.springframework.context.annotation.ConfigurationClassParser#parse(AnnotationMetadata, String)
     */
    protected final void parse(Class<?> clazz, String beanName) throws IOException {

    }

    /**
     * @see org.springframework.context.annotation.ConfigurationClassParser#processConfigurationClass(org.springframework.context.annotation.ConfigurationClass, Predicate)
     */
    protected void processConfigurationClass(Object configClass, Predicate<String> filter) throws IOException {

    }

    /**
     * @see org.springframework.context.annotation.ConfigurationClassParser#doProcessConfigurationClass(org.springframework.context.annotation.ConfigurationClass, org.springframework.context.annotation.ConfigurationClassParser.SourceClass, Predicate)
     *
     * ComponentScans / Component / PropertySources / Import 핵심이다.
     */
    protected final Object doProcessConfigurationClass(
            Object configClass, Object sourceClass, Predicate<String> filter)
            throws IOException {
        return null;
    }

    private void processImports(Object configClass, Object currentSourceClass,
                                Collection<Object> importCandidates, Predicate<String> exclusionFilter,
                                boolean checkForCircularImports) {
    }

    private Set<Object> getImports(Object sourceClass) throws IOException {
        Set<Object> imports = new LinkedHashSet<>();
        Set<Object> visited = new LinkedHashSet<>();
        collectImports(sourceClass, imports, visited);
        return imports;
    }

    /**
     * Import Annoation을 가져온다.
     */
    private void collectImports(Object sourceClass, Set<Object> imports, Set<Object> visited)
            throws IOException {
    }

    /**
     * configClass에 의해 구현된 인터페이스 기본 메서드를 등록합니다.
     *
     */
    private void processInterfaces(Object configClass, Object sourceClass) throws IOException {
        retrieveBeanMethodMetadata(configClass);
    }

    /**
     * Retrieve the metadata for all <code>@Bean</code> methods.
     */
    private Set<MethodMetadata> retrieveBeanMethodMetadata(Object sourceClass) {
        return Set.of();
    }
}
