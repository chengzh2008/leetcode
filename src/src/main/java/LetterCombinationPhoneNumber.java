package src.main.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class LetterCombinationPhoneNumber {
    public List<String> letterCombinations(String digits) {
        String[] digitMap = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<String>();
        getCombine(digitMap, digits, 0, "", res);
        return res;
    }

    public void getCombine(String[] digitMap, String digits, int start, String cur, List<String> res) {
        if (start == digits.length()) {
            res.add(cur);
            return;
        }
        String seq = digitMap[digits.charAt(start) - '0'];
        for (int i = 0; i < seq.length(); i++) {
            getCombine(digitMap, digits, start + 1, cur + seq.charAt(i), res);
        }
    }

    public static void main(String[] args) {
        LetterCombinationPhoneNumber letterCombinationPhoneNumber = new LetterCombinationPhoneNumber();
        System.out.println(letterCombinationPhoneNumber.letterCombinations("23"));
    }
}
