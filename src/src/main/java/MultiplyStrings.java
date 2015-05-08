package src.main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 * <p>
 * Note: The numbers can be arbitrarily large and are non-negative.
 *
 * Strategy:
 * 1. determine who is the longest string.
 * 2. create a list of Integer hold this long string.
 * 3. create a function, take this list, numberToMultiply, index, return a list of integer.
 * 4. sum up all the lists.
 *
 *
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1 == null || num1.isEmpty() || num2 == null || num2.isEmpty()) return "";
        if (num1.length() ==1 && num1.charAt(0) == '0' || num2.length() == 1 && num2.charAt(0) == '0') return "0";
        int len1 = num1.length();
        int len2 = num2.length();
        String longNum = len1 > len2 ? num1 : num2;
        String shortNum = len1 <=len2 ? num1 : num2;
        // create a list of Integer represent longNum
        List<Integer> longList = new ArrayList<>();
        for(int i = longNum.length()-1; i>= 0; i--) {
            longList.add(charToInt(longNum, i));
        }
        // list to hold the result
        List<Integer> result = new ArrayList<>();
        // list to hold the current result from single digit miltiplication
        List<Integer> current;
        for(int i = 0; i < shortNum.length(); i++) {
            int currentDigit = charToInt(shortNum, shortNum.length()-1-i);
            if (currentDigit != 0) {
                current = multiplyByDigit(longList, currentDigit, i);
                listPlusPlus(result, current);
            }
        }

        // convert resut list to string
        StringBuilder sb = new StringBuilder();
        for(int i : result) {
            sb.append(i);
        }

        return sb.reverse().toString();
    }

    private void listPlusPlus(List<Integer> result, List<Integer> nums) {
        assert(result.size() <= nums.size());
        int carryover = 0;
        for(int i = 0; i< nums.size(); i++) {
            int numFromResult = result.size() <= i? 0 : result.get(i);
            int current = carryover + numFromResult + nums.get(i);
            carryover = current / 10;
            if (result.size() <= i) {
                result.add(current % 10);
            } else {
                result.set(i, current % 10);
            }
        }
        if (carryover > 0) {
            result.add(carryover);
        }

    }

    private List<Integer> multiplyByDigit(List<Integer> longList, int currentDigit, int start) {
        List<Integer> result = new ArrayList<>();
        // initiallize the result with pre-filled 0
        for(int i = 0; i<start; i++) {
            result.add(0);
        }
        int carryOver = 0;
        for(int i = 0; i< longList.size(); i++) {
            int current = carryOver + longList.get(i) * currentDigit;
            carryOver = current/10;
            result.add(current%10);
        }
        if (carryOver > 0) {
            result.add(carryOver);
        }
        return result;
    }

    private Integer charToInt(String longNum, int i) {
        return longNum.charAt(i) - '0';
    }

    public static void main(String[] args) {
        MultiplyStrings multiplyStrings = new MultiplyStrings();
        // test charToInt method
        System.out.println(multiplyStrings.charToInt("23432", 1));
        // test single digit multiply method
        Integer[] arr = { 4, 2, 1};
        List<Integer> longList = new ArrayList<>(Arrays.asList(arr));
        System.out.println(multiplyStrings.multiplyByDigit(longList, 3, 1));

        System.out.println(multiplyStrings.multiply("123493719398498149489434148338434899493418", "10"));
        System.out.println(multiplyStrings.multiply("0", "10"));
        System.out.println(multiplyStrings.multiply("123", "456"));


    }
}
