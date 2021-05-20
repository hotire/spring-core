package com.kakao.hotire.hierarchy.sibling;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@PropertySource("classpath:/hierarchy/sibling/application.yml")
public class SiblingContext implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("SiblingContext");
    }
}
