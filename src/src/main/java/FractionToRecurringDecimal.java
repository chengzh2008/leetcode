package src.main.java;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyazi on 1/20/15.
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 * <p>
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * <p>
 * For example,
 * <p>
 * Given numerator = 1, denominator = 2, return "0.5".
 * Given numerator = 2, denominator = 1, return "2".
 * Given numerator = 2, denominator = 3, return "0.(6)".
 */
public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        // assert denominator is not zero
        if (denominator == 0) throw new IllegalArgumentException("denominator can not be 0");
        StringBuilder stringBuilder = new StringBuilder();
        // deal with negative number
        if ((numerator > 0 && denominator < 0) || (numerator< 0 && denominator> 0)) {
            stringBuilder.append("-");
        }
        // prevent int overflow
        long num = Math.abs(((long)numerator));
        long deNom = Math.abs((long)denominator);
        stringBuilder.append(num/deNom);
        long remainder = num%deNom;
        if (remainder != 0) {
            stringBuilder.append(".");
        }
        // remember the position to repeat
        Map<Long, Integer> map = new HashMap<>();
        while(remainder != 0 && !map.containsKey(remainder) ) {
            map.put(remainder, stringBuilder.length());
            stringBuilder.append(remainder*10/deNom);
            remainder = remainder* 10%deNom;
        }
        // if start to repeat, insert "(" and append ")"
        if (map.containsKey(remainder)) {
            stringBuilder.insert(map.get(remainder), "(");
            stringBuilder.append(")");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new FractionToRecurringDecimal().fractionToDecimal(-1, -2147483648));
        System.out.println(new FractionToRecurringDecimal().fractionToDecimal(1, 6));
        System.out.println(new FractionToRecurringDecimal().fractionToDecimal(22, 7));
        System.out.println(new FractionToRecurringDecimal().fractionToDecimal(2, 3));
        System.out.println(new FractionToRecurringDecimal().fractionToDecimal(1, 333));
        System.out.println(new FractionToRecurringDecimal().fractionToDecimal(1, 500));
        System.out.println(new FractionToRecurringDecimal().fractionToDecimal(1, 333));





    }
}
