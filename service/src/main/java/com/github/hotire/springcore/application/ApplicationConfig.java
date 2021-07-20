package com.github.hotire.springcore.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

  @Bean
  public com.github.hotire.springcore.application.BookRepository bookRepository() {
    return new BookRepository();
  }

  @Bean
  public com.github.hotire.springcore.application.BookService bookService() {
    com.github.hotire.springcore.application.BookService bookService = new BookService();
    bookService.setBookRepository(bookRepository());
    return bookService;
  }

}
