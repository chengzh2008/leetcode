package src.main.java;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyazi on 1/11/15.
 * Given a roman numeral, convert it to an integer.
 * <p/>
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return map.get(s.charAt(0));

        int len = s.length();
        int index = 0;
        int sum = 0;
        int current, after;
        while (index < len - 1) {
            current = map.get(s.charAt(index));
            after = map.get(s.charAt(index + 1));
            if (current >= after) {
                sum += current;
                index++;
            } else {
                sum += after - current;
                index += 2;
            }
        }
        // if index is the last character in the string
        if (index == len - 1) {
            sum += map.get(s.charAt(index));
            return sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();
        int test = romanToInteger.romanToInt("MCMXCVI");
        System.out.println(test);
    }

}
