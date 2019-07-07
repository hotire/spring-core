package com.kakao.hotire.springcore.spel;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

public class StandardEvaluationContextTest {

  ExpressionParser parser = new SpelExpressionParser();

  class Simple {
    public List<Boolean> booleanList = new ArrayList<Boolean>();
  }

  @Test
  public void setValue() {
    // Given
    Simple simple = new Simple();
    simple.booleanList.add(true);
    EvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();


    // When
    parser.parseExpression("booleanList[0]").setValue(context, simple, "false");

    // Then
    Boolean result = simple.booleanList.get(0);
    Assertions.assertThat(result).isFalse();
  }
}
