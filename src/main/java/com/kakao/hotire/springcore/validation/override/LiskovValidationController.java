package com.kakao.hotire.springcore.validation.override;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Validated
//@RestController
@RequestMapping("/liskov/validation/")
public class LiskovValidationController extends AbstractValidationController {
    /**
     * HV000151: A method overriding another method must not redefine the parameter constraint configuration,
     *
     * The exception is raised if you add parameter constraints to a method which overrides or implements a super-type method.
     * This behavior is mandated by the Bean Validation spec
     * (see http://beanvalidation.org/1.1/spec/#constraintdeclarationvalidationprocess-methodlevelconstraints-inheritance)
     * in order to obey to the Liskov substitution principle:
     *
     */
    @Override
    void overrideValidation(@Validated @Length(min = 3) @PathVariable String id) {
        log.info("id : {}", id);
    }
}
