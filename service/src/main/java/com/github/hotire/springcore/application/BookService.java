package com.github.hotire.springcore.application;


import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BookService {
  @Setter @Getter
  private BookRepository bookRepository;

  public BookService() {
    log.debug("init");
  }
}
