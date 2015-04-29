package src.main.java;

import java.util.LinkedList;
import java.util.List;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * <p>
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * <p>
 * The number of ways decoding "12" is 2.
 */
public class DecodeWays {


    // Dynamic programming.
    public int numDecodingsDP(String s) {
        if (s == null || s.isEmpty()) return 0;
        int len = s.length();
        int[] ways = new int[len];
        // initialize the last number in the ways
        if(isValid(s.charAt(len-1))) {
            ways[len-1] = 1;
        }
        // move on if len >= 2
        if (len >= 2) {
            // determine the value for the second last char
            if (isValid(s.charAt(len-2), s.charAt(len-1))) {
                ways[len-2] = ways[len-1] + 1;
            } else if (isValid(s.charAt(len-2))) {
                ways[len-2] = ways[len-1] ;
            }

            for (int i = len-3; i >=0; i--) {
                if(isValid(s.charAt(i))) {
                    ways[i] = ways[i+1];
                }
                if (isValid(s.charAt(i), s.charAt(i+1))) {
                    ways[i] = ways[i+1] + ways[i+2];
                }
            }
        }
        return ways[0];
    }

    public boolean isValid(char c) {
        return  c > '0' && c <= '9';
    }

    public boolean isValid(char c1, char c2) {
        return  c1 == '1' || (c1 == '2' && c2 >= '0' && c2 <= '6');
    }
    // recursive method, you will get a TLE (Time Limit Exceeded).
    public List<String> numDecodings(String s) {
        String map = "1ABCDEFGHIGKLMNOPQRSTUVWXYZ";
        int len = map.length();
        List<String> result = new LinkedList<>();
        if (s == null || s.length() == 0) return result;
        List<Character> lc = new LinkedList<>();
        helper(s, 0, lc, result, map);
        return result;
    }

    public void helper(String s, int start, List<Character> lc, List<String> result, String map) {
        if (start == s.length()) {
            result.add(lc.toString());
            return;
        } else {
            String sub1 = s.substring(start, start+1);
            lc.add(map.charAt(Integer.parseInt(sub1)));
            helper(s, start+1, lc, result, map);
            lc.remove(lc.size()-1);
            if (start <= s.length()-2) {
                String sub2 = s.substring(start, start+2);
                int sub2Num = Integer.parseInt(sub2);
                if (sub2Num < map.length() && sub2Num >0) {
                    lc.add(map.charAt(sub2Num));
                    helper(s, start+2, lc, result, map);
                    lc.remove(lc.size()-1);
                }
            }
        }
    }

    public static void main(String[] args) {
        DecodeWays decodeWays = new DecodeWays();
        System.out.println(decodeWays.numDecodingsDP("10"));
    }
}
