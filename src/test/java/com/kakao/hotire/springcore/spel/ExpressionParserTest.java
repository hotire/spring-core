package com.kakao.hotire.springcore.spel;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;


/**
 * https://engkimbs.tistory.com/741
 *
 * https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#expressions
 *
 * https://rahs.tistory.com/197
 *
 * https://blog.outsider.ne.kr/835
 */
public class ExpressionParserTest {

  @Test
  public void parse() {
    ExpressionParser parser = new SpelExpressionParser();
    Expression exp = parser.parseExpression("'Hello World'");
    String message = (String) exp.getValue();

    assertThat(message).isEqualTo("Hello World");
  }

  @Test
  public void concat() {
    ExpressionParser parser = new SpelExpressionParser();
    Expression exp = parser.parseExpression("'Hello World'.concat('!')");
    String message = (String) exp.getValue();

    assertThat(message).isEqualTo("Hello World!");
  }

  @Test
  public void length() {
    ExpressionParser parser = new SpelExpressionParser();
    Expression exp = parser.parseExpression("'Hello World'.length()");
    Integer length = (Integer) exp.getValue();

    assertThat(length).isEqualTo(11);
  }

  @Test
  public void constructor() {
    ExpressionParser parser = new SpelExpressionParser();
    Expression exp = parser.parseExpression("new String('hello world').toUpperCase()");
    String message = exp.getValue(String.class);

    assertThat(message).isEqualTo("HELLO WORLD");
  }
}
