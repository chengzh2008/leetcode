package src.main.java;

/**
 * Created by xiaoyazi on 1/6/15.
 */
public class ExcelSheetColumnTitle {
    public class Solution {
        public String convertToTitle(int n) {
            String chars = "0ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            StringBuilder stringBuilder = new StringBuilder();
            while (n > 0) {
                int digit = n % 26;
                stringBuilder.append(chars.charAt(digit == 0 ? 26 : digit));
                n = digit == 0 ? (n / 26 - 1) : n / 26;
            }
            return stringBuilder.reverse().toString();
        }
    }
}
