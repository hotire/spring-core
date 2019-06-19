package com.kakao.hotire.springcore.application;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationConfigTest {

  @Test
  public void configByAnnotation() {
    ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
    assert_di(context);
  }

  @Test
  public void configByXml() {
    ApplicationContext context = new ClassPathXmlApplicationContext("xml/application.xml");
    assert_di(context);
  }

  private void assert_di(ApplicationContext context) {
    // When
    BookRepository bookRepository = context.getBean(BookRepository.class);
    BookService bookService = context.getBean(BookService.class);
    BookRepository ref = bookService.getBookRepository();

    // Then
    assertThat(bookRepository).isNotNull();
    assertThat(bookService).isNotNull();
    assertThat(ref).isNotNull();
    assertThat(ref).isEqualTo(bookRepository);
  }
}