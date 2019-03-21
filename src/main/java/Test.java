import com.shekhar.expressioncalculator.Expression;
import com.shekhar.expressioncalculator.ExpressionParser;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args){

        //projections==> month, sum(numerator) as num, sum(denominator) as denum
        //computed_projection==> ratio=(num * 100)/denum

        Map<String, Object> data = new HashMap<>();
        data.put("numerator", BigDecimal.valueOf(50));
        data.put("denominator", BigDecimal.valueOf(1000));
//      data.put("c", BigDecimal.valueOf(12));
//      data.put("d", BigDecimal.valueOf(14));
//      data.put("e", BigDecimal.valueOf(6));

        Expression expression = ExpressionParser.init("percentage_amount=( numerator * 100 ) / denominator");
        expression.evaluate(data);
       for(Map.Entry<String, Object> entry : data.entrySet()){
           System.out.println(entry.getKey()+"    "+entry.getValue());
       }


//        System.out.println("a * ( b + c ) / d  ==>"+ExpressionParser.init("a * ( b + c ) / d").evaluate(data).getData());
//
//
//        System.out.println("a * ( b + c )   ==>"+ExpressionParser.init("a * ( b + c)").evaluate(data).getData());
//
//
//        System.out.println("a +  b  * e  ==>"+ExpressionParser.init("a +  b  * e").evaluate(data).getData());
//
//
//        System.out.println("(c - b) * 100.1  ==>"+ExpressionParser.init("(c -  b) * 100.1").evaluate(data).getData());
//
//        System.out.println("((c - b) * 100.1) > 20 ==>"+ExpressionParser.init("((c - b) * 100.1) > 20").evaluate(data).getData());
    }

}
