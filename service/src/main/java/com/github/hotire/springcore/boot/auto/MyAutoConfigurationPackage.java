package com.github.hotire.springcore.boot.auto;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.boot.autoconfigure.AutoConfigurationPackages;
import org.springframework.context.annotation.Import;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(DefaultAutoConfigurationPackages.CustomRegister.class)
public @interface MyAutoConfigurationPackage {

    /**
     * Base packages that should be registered with {@link AutoConfigurationPackages}.
     * <p>
     * Use {@link #basePackageClasses} for a type-safe alternative to String-based package
     * names.
     * @return the back package names
     * @since 2.3.0
     */
    String[] basePackages() default {};

    /**
     * Type-safe alternative to {@link #basePackages} for specifying the packages to be
     * registered with {@link AutoConfigurationPackages}.
     * <p>
     * Consider creating a special no-op marker class or interface in each package that
     * serves no purpose other than being referenced by this attribute.
     * @return the base package classes
     * @since 2.3.0
     */
    Class<?>[] basePackageClasses() default {};
}
