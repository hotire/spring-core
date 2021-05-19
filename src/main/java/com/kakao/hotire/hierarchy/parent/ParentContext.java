package com.kakao.hotire.hierarchy.parent;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:/hierarchy/parent/application.yml")
public class ParentContext {
}
