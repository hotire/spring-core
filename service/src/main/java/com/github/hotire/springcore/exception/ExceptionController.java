package com.github.hotire.springcore.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/exception")
@RestController
public class ExceptionController {

    @GetMapping
    public ResponseEntity exception() {
        throw new CustomException();
    }

    @GetMapping("/500")
    public ResponseEntity internalError() throws Exception {
        throw new Exception("");
    }
}
