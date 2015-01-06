package src.main.java;




///**
// * Given a column title as appear in an Excel sheet, return its corresponding column number.
//
// For example:
//
// A -> 1
// B -> 2
// C -> 3
// ...
// Z -> 26
// AA -> 27
// AB -> 28
// */
// basically it is a problem of base-26 to decimal transformation
public class ExcelSheetColumnNumber {
        public int titleToNumber(String s) {
            String chars = "0ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            int result = 0;
            for (int i = 0; i< s.length(); i++) {
                result *= 26;
                result += chars.indexOf(s.charAt(i));
            }
            return result;
        }

}
