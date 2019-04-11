package com.kakao.hotire.springcore.formatter;

import lombok.Data;

@Data
public class Person {
  private Integer id;
  private String name;

  private Person() {}
  private Person(String name) {
    this.name = name;
  }

  public static Person of(String name) {
    return new Person(name);
  }
}
