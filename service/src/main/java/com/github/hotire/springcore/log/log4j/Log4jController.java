package com.github.hotire.springcore.log.log4j;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class Log4jController {

    @GetMapping("/log/log4j")
    public void hello() {
        log.info("hello log4j");
    }
}
