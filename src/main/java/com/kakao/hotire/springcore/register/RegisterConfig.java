package com.kakao.hotire.springcore.register;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(PersonRegister.class)
@Configuration
public class RegisterConfig {
}
