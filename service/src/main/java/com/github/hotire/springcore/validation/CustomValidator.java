package com.github.hotire.springcore.validation;

import java.util.Set;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.github.hotire.springcore.validation.Validation.Entry;

import lombok.extern.slf4j.Slf4j;

/**
 * @see org.springframework.validation.beanvalidation.SpringConstraintValidatorFactory 에 의해 Bean으로 등록된다.
 *
 */
@Slf4j
public class CustomValidator implements ConstraintValidator<CustomValidation, Set<Entry>> {


    public CustomValidator() {
        System.out.println("");
    }


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
