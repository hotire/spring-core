package com.github.hotire.springcore.bean.scope;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomScopeConfig {

    @Bean
    public CustomScopeConfigurer customScopeConfigurer() {
        final CustomScopeConfigurer customScopeConfigurer = new CustomScopeConfigurer();
        customScopeConfigurer.addScope(com.github.hotire.springcore.bean.scope.CustomScope.CUSTOM_SCOPE, new CustomScope());
        return customScopeConfigurer;
    }

}
