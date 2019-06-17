package com.kakao.hotire.springcore.application;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationTest {

  @Test
  public void di() {
    // Given
    ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");

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