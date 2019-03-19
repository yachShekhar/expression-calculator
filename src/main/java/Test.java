import com.shekhar.expressioncalculator.ExpressionParser;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args){

        Map<String, BigDecimal> data = new HashMap<>();
        data.put("a", BigDecimal.valueOf(100));
        data.put("b", BigDecimal.valueOf(2));
        data.put("c", BigDecimal.valueOf(12));
        data.put("d", BigDecimal.valueOf(14));
        data.put("e", BigDecimal.valueOf(6));
//        System.out.println("a * ( b + c ) / d  ==>"+ExpressionParser.init("a * ( b + c ) / d").evaluate(data).getData());
//
//
//        System.out.println("a * ( b + c )   ==>"+ExpressionParser.init("a * ( b + c)").evaluate(data).getData());
//
//
//        System.out.println("a +  b  * e  ==>"+ExpressionParser.init("a +  b  * e").evaluate(data).getData());


        System.out.println("(c - b) * 100.1  ==>"+ExpressionParser.init("(c -  b) * 100.1").evaluate(data).getData());
    }
}
