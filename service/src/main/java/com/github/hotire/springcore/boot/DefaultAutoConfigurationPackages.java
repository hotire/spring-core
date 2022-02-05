package com.github.hotire.springcore.boot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.autoconfigure.AutoConfigurationPackages;
import org.springframework.boot.context.annotation.DeterminableImports;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.ClassUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * @see org.springframework.boot.autoconfigure.SpringBootApplication
 * @see org.springframework.boot.autoconfigure.EnableAutoConfiguration
 * @see org.springframework.boot.autoconfigure.AutoConfigurationPackage
 * @see org.springframework.boot.autoconfigure.AutoConfigurationPackages.Registrar
 */
@Slf4j
public class DefaultAutoConfigurationPackages extends AutoConfigurationPackages {

    public static class CustomRegister implements ImportBeanDefinitionRegistrar, DeterminableImports {

        @Override
        public Set<Object> determineImports(AnnotationMetadata metadata) {
            return Collections.singleton(new DefaultAutoConfigurationPackages.PackageImports(metadata));
        }

        @Override
        public void registerBeanDefinitions(AnnotationMetadata metadata, BeanDefinitionRegistry registry) {
            new PackageImports(metadata).getPackageNames().forEach(log::info);  // com.github.hotire.springcore.boot
        }
    }

    private static final class PackageImports {

        private final List<String> packageNames;

        PackageImports(AnnotationMetadata metadata) {
            AnnotationAttributes attributes = AnnotationAttributes
                    .fromMap(metadata.getAnnotationAttributes(MyAutoConfigurationPackage.class.getName(), false));
            assert attributes != null;
            final List<String> packageNames = new ArrayList<>(Arrays.asList(attributes.getStringArray("basePackages")));
            for (Class<?> basePackageClass : attributes.getClassArray("basePackageClasses")) {
                packageNames.add(basePackageClass.getPackage().getName());
            }
            if (packageNames.isEmpty()) {
                packageNames.add(ClassUtils.getPackageName(metadata.getClassName()));
            }
            this.packageNames = Collections.unmodifiableList(packageNames);
        }

        List<String> getPackageNames() {
            return this.packageNames;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.packageNames.equals(((DefaultAutoConfigurationPackages.PackageImports) obj).packageNames);
        }

        @Override
        public int hashCode() {
            return this.packageNames.hashCode();
        }

        @Override
        public String toString() {
            return "Package Imports " + this.packageNames;
        }

    }
}
