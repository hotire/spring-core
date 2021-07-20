package com.github.hotire.springcore.validation;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/validation")
public class ValidationController {

    /**
     * Validated 동작하지 않음
     */
    @GetMapping
    public ResponseEntity<com.github.hotire.springcore.validation.Validation> validation(@Valid Validation validation) {
        return ResponseEntity.ok(validation);
    }

    /**
     * Valid 동작하지 않음
     */
    @GetMapping("/2")
    public ResponseEntity<String> validation2(@Valid @NotEmpty String name) {
        return ResponseEntity.ok(name);
    }

    /**
     * Valid / Validated 둘다 상관없이 동작함.
     * ModelAttributeMethodProcessor.determineValidationHints
     */
    @GetMapping("/3")
    public ResponseEntity<com.github.hotire.springcore.validation.ValidationRequest> validation(@Valid com.github.hotire.springcore.validation.ValidationRequest request) {
        return ResponseEntity.ok(request);
    }

    /**
     * ModelAttributeMethodProcessor의 Validation으로 동작함
     */
    @PostMapping
    public ResponseEntity<com.github.hotire.springcore.validation.ValidationRequest> post(@Validated ValidationRequest request) {
        return ResponseEntity.ok(request);
    }
}
