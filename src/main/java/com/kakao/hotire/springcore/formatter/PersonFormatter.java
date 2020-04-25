package com.kakao.hotire.springcore.formatter;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class PersonFormatter implements Formatter<Person> {

  @Override
  public Person parse(String s, Locale locale) throws ParseException {
    return Person.of(s+", by PersonFormatter");
  }

  @Override
  public String print(Person person, Locale locale) {
    return person.toString();
  }
}
