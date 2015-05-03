package src.main.java;

/**
 * Given a string S, find the longest palindromic substring in S. You may assume that
 * the maximum length of S is 1000, and there exists one unique longest palindromic
 * substring.
 * <p>
 * Show Tags
 */
public class LongestPalindromeString {
    public String longestPalindrome(String s) {
        int n = s.length();
        int max = 1; // maximum length of palindrome string
        int start = 0;
        int end = 0;
        // build a table to give palindrome infomation of substring constant time.
        boolean[][] isPalindrome = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (i - j == 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        isPalindrome[j][i] = true;
                        if (i - j + 1 > max) {
                            max = i - j + 1;
                            start = j;
                            end = i;
                        }
                    }
                } else {
                    isPalindrome[j][i] = isPalindrome[j + 1][i - 1] && s.charAt(j) == s.charAt(i);
                    if (isPalindrome[j][i]) {
                        if (i - j + 1 > max) {
                            max = i - j + 1;
                            start = j;
                            end = i;
                        }
                    }
                }
            }
        }

        return s.substring(start, end + 1);

    }
}
