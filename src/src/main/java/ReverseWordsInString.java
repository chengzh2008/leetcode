package src.main.java;

/**
 * Given an input string, reverse the string word by word.
 *
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 *
 * Update (2015-02-12):
 * For C programmers: Try to solve it in-place in O(1) space.
 *
 * click to show clarification.
 *
 * Clarification:
 * What constitutes a word?
 * A sequence of non-space characters constitutes a word.
 * Could the input string contain leading or trailing spaces?
 * Yes. However, your reversed string should not contain leading or trailing spaces.
 * How about multiple spaces between two words?
 * Reduce them to a single space in the reversed string.
 */
public class ReverseWordsInString {
    public String reverseWords(String s) {
        String[] input = s.trim().split("\\s+ ");
        String output = "";
        if (input.length > 0) {
            output = input[input.length-1];
        }
        for (int i = input.length-2; i>=0; i--) {
            output = output + " " + input[i];
        }
        return output;
    }

    public static void main(String[] args) {
        String s = " this is a sentence";
        ReverseWordsInString reverseWordsInString = new ReverseWordsInString();
        System.out.println(reverseWordsInString.reverseWords(s));
    }
}
