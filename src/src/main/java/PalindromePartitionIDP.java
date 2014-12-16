package src.main.java;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.List;

/**
 * Palindrome Partitioning
 * <p/>
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * <p/>
 * Return all possible palindrome partitioning of s.
 * <p/>
 * For example, given s = "aab",
 * Return
 * <p/>
 * <p/>
 * 1
 * 2
 * 3
 * 4
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 */
public class PalindromePartitionIDP {
    public List<List<String>> getListDP(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = n -1; i>=0; i--) {
            for (int j = i+1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j-i < 2 || isPalindrome[i + 1][j - 1]) {
                        isPalindrome[i][j] = true;
                    }
                }
            }
        }

        // create an array of List<List<String>> to save the lists of the
        List<List<String>>[] palindromes = (List<List<String>>[]) Array.newInstance(List.class, n + 1);
        // initialize the n + 1 element in this array palindromes
        palindromes[n] = new LinkedList<List<String>>();
        List<String> emptyList = new LinkedList<String>();
        palindromes[n].add(emptyList);

        // loop through the string from right to left and process the palindrome[i]
        for (int i = n -1; i >=0; i--) {
            // initialize the element in the array
            palindromes[i] = new LinkedList<List<String>>();
            for (int j = i; j < n; j++) {
                if (isPalindrome[i][j]) {
                    List<List<String>> lists = palindromes[j+1];
                    String subString = s.substring(i, j+1);
                    for (List<String> list : lists) {
                        List<String> newList = new LinkedList<String>();
                        newList.add(subString);
                        newList.addAll(list);
                        palindromes[i].add(newList);
                    }
                }
            }
        }
        return palindromes[0];
    }
}
