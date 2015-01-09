package src.main.java;

import java.util.Stack;

/**
 * Created by xiaoyazi on 1/8/15.
 * Given two binary strings, return their sum (also a binary string).
 * <p/>
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        Stack<Character> stack = new Stack<Character>();
        int lenA = a.length();
        int lenB = b.length();
        int maxLen = Math.max(lenA, lenB);
        // convert char to int for calculation, then convert it back to char
        int int1, int2;
        int newInt;
        int carryover = 0;
        int i = 0;
        while (i < maxLen) {
            int1 = i >= lenA ? 0 : a.charAt(lenA- i - 1) - '0';
            int2 = i >= lenB ? 0 : b.charAt(lenB - i - 1) - '0';
            newInt = (int1 + int2 + carryover) % 2;
            carryover = (int1 + int2 + carryover) / 2;
            stack.push((char) (newInt + '0'));
            i++;
        }
        if (carryover == 1) {
            stack.push((char) (carryover + '0'));
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();
    }
}
