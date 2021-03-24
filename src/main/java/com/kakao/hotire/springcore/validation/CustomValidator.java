package com.kakao.hotire.springcore.validation;

import java.util.Set;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.kakao.hotire.springcore.validation.Validation.Entry;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomValidator implements ConstraintValidator<CustomValidation, Set<Entry>> {
    @Override
    public void initialize(CustomValidation constraintAnnotation) {

    }
    @Override
    public boolean isValid(Set<Entry> values, ConstraintValidatorContext context) {
        log.info("values : {}", values);
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate("hello")
               .addConstraintViolation();
        return false;
    }
}
