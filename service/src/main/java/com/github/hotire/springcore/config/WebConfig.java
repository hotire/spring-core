package com.github.hotire.springcore.config;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/simple2").setViewName("/index");
  }

  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    converters.stream()
              .filter(it -> it instanceof AbstractHttpMessageConverter)
              .map(AbstractHttpMessageConverter.class::cast)
              .forEach(it -> it.setDefaultCharset(StandardCharsets.UTF_8));
  }
}
