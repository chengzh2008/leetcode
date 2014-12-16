package src.main.java;

/**
 Palindrome Partitioning II

 Given a string s, partition s such that every substring of the partition is a palindrome.

 Return the minimum cuts needed for a palindrome partitioning of s.

 For example, given s = "aab",
 Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
public class PalindromePartitionII {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        for (int i =0; i< n; i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = n-1; i>= 0; i--) {
            for (int j = i +1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 2 || isPalindrome[i+1][j-1]) {
                        isPalindrome[i][j] = true;
                    }

                }
            }
        }
        int[] minCut = new int[n +1];
        for (int i = n; i >=0; i--) {
            minCut[i] = n -1 -i;
        }
        for (int i = n -1; i >=0; i--) {
            for (int j = i; j < n; j++) {
                if (isPalindrome[i][j]) {
                    minCut[i] = Math.min(minCut[i], 1 + minCut[j + 1]);
                }
            }
        }
        return minCut[0];
    }
}
