package com.kakao.hotire.springcore.application;


import lombok.Getter;
import lombok.Setter;

public class BookService {
  @Setter @Getter
  private BookRepository bookRepository;
}
