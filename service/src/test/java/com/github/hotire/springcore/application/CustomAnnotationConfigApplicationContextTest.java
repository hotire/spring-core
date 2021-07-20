package com.github.hotire.springcore.application;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class CustomAnnotationConfigApplicationContextTest {

  @Test
  void config_custom() {
    final BeanFactory context =
            new CustomAnnotationConfigApplicationContext(ApplicationConfig.class);
    log.debug("before getBean()");
    context.getBean(BookService.class);
  }

  @Test
  void config_beanFactory() {
    final BeanFactory context = new XmlBeanFactory(new ClassPathResource("xml/application.xml"));
    log.debug("before getBean()");
    context.getBean(BookService.class);
  }

  @Test
  void config() {
    final BeanFactory context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
    log.debug("before getBean()");
    context.getBean(BookService.class);
  }
}