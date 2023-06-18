package com.SpEL.spel;

import com.SpEL.spel.data.User;
import org.springframework.expression.Expression;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class AppExpressionParser {

    public static void main(String[] args) {
        SpelExpressionParser parser = new SpelExpressionParser();
        Expression exp1 = parser.parseExpression("'HALLO'");

        System.out.println(exp1.getValue());
        Expression exp2 = parser.parseExpression("'HALLO'.length()");
        Expression exp3 = parser.parseExpression("'HALLO'.length()*10");
        Expression exp4 = parser.parseExpression("'HALLO'.length()<10");
        Expression exp5 = parser.parseExpression("'HALLO'.length()<10 and 'HALLOO'.length()>1");

//        System.out.println(exp1.getValue()
//                +"\n"+exp2.getValue()
//                +"\n"+exp3.getValue()
//                +"\n"+exp4.getValue()
//                +"\n"+exp5.getValue());

        StandardEvaluationContext ec1  =new StandardEvaluationContext();
        ec1.setVariable("HALLO","HALLO USA");
        ec1.setVariable("Joe","Mama");
        String msg = (String)
                parser.parseExpression("#HALLO.substring(6)")
                        .getValue(ec1);
        System.out.println(msg);
        Expression math = parser.parseExpression("'Joe bye then'");
        System.out.println(math.getValue(ec1));


        User user = new User("BG","Bulgaria");
        StandardEvaluationContext userContext = new StandardEvaluationContext(user);
        parser.parseExpression("country").setValue(userContext,"Jamaika");
        System.out.println(user.getCountry());

        parser.parseExpression("name").setValue(userContext,"Carlos");
        System.out.println(user.getName());
        parser.parseExpression("age").setValue(userContext,42);
        System.out.println(user.getAge());
        parser.parseExpression("language").setValue(userContext,"Jamaican Patois");

        System.out.println(user.getLanguage());
        parser.parseExpression("timeZone").setValue(userContext,"No.");
        System.out.println(user.getTimeZone());


        StandardEvaluationContext propContext = new StandardEvaluationContext();
        propContext.setVariable("systemProperties",System.getProperties());
        Expression expCountry = parser.parseExpression("#systemProperties['user.country']");
        parser.parseExpression("country").setValue(userContext,expCountry.getValue(propContext));
        System.out.println(user.getCountry());
//        System.out.println(System.getProperties());
        System.out.println();
        TemplateParserContext templateParserContext = new TemplateParserContext();
        Expression exp10 = parser.parseExpression("'Joe ' + #Joe");
        System.out.println(exp10.getValue(ec1));


    }
}
