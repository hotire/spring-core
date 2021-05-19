package com.kakao.hotire.child;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:/child/application.yml")
public class ChildContext {
}
