package src.main.java;

import java.util.Arrays;

/**
 *
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * <p/>
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * <p/>
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class LargestNumber {
    public String largestNumber(int[] num) {
        if (num == null || num.length == 0) return "";
        String[] s = Arrays.stream(num).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(s, (String s1, String s2) -> (s2 + s1).compareTo(s1 + s2));
        String out = Arrays.stream(s).reduce((x, y) -> x.equals("0")? y : x + y).get();
        return out;
    }

    public static void main(String[] args) {
        int[] num = {0,0,0,0,1};

        System.out.println(new LargestNumber().largestNumber(num));
    }
}
