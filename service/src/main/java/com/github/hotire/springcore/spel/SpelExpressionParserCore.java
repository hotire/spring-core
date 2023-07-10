package com.github.hotire.springcore.spel;
import org.springframework.expression.ParseException;
import org.springframework.expression.ParserContext;
import org.springframework.expression.spel.standard.SpelExpression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.lang.Nullable;


/**
 * @see SpelExpressionParser
 */
public class SpelExpressionParserCore {

    /**
     * @see SpelExpressionParser#doParseExpression(String, ParserContext)
     */
    protected SpelExpression doParseExpression(String expressionString, @Nullable ParserContext context) throws ParseException {
        return null;
    }
}
