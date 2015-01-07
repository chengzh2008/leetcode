package src.main.java;

/**
 * Created by xiaoyazi on 1/6/15.
 */
public class ValidPalindrome {
    public class Solution {
        public boolean isPalindrome(String s) {
            StringBuilder stringBuilder = new StringBuilder(s.replaceAll("[^A-Za-z0-9 ]", "").toLowerCase());
            return stringBuilder.toString().equals((stringBuilder.reverse().toString()));
        }
    }
}
