package com.kakao.hotire.springcore.validation.override;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public abstract class AbstractValidationController {

    @GetMapping("/{id}")
    abstract void overrideValidation(@PathVariable String id);
}
