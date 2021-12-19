package com.github.hotire.springcore.validation;

import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import lombok.RequiredArgsConstructor;

/**
 * @see org.springframework.validation.beanvalidation.LocalValidatorFactoryBean
 */
@RequiredArgsConstructor
public class CustomLocalValidatorFactoryBean {

    private final LocalValidatorFactoryBean localValidatorFactoryBean;

    public void init() {
        localValidatorFactoryBean.getConstraintValidatorFactory().getInstance(CustomValidator.class);
    }
}
