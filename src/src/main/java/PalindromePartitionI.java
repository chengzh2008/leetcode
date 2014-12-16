package src.main.java;

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
public class PalindromePartitionI {

    private String s;
    private boolean[][] isPalindrome;
    private List<List<String>> listOfList;

    public PalindromePartitionI(String s) {
        this.s = s;
        listOfList = new LinkedList<List<String>>();
        int n = s.length();
        isPalindrome = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 2 || isPalindrome[i + 1][j - 1]) {
                        isPalindrome[i][j] = true;
//                        System.out.println(isPalindrome);
                    }
                }
            }
        }
    }

    public List<List<String>> getListRecursive() {

        List<String> list = new LinkedList<String>();
        partition(s, 0, list);
        return listOfList;
    }

    private void partition(String s, int start, List<String> list) {
        if (start == s.length()) {
            List<String> newList = new LinkedList<String>();
//            System.out.println("creating a new list");
            newList.addAll(list);
            listOfList.add(newList);
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome[start][i]) {
                list.add(s.substring(start, i + 1));
//                System.out.println("list so far " + list);
                partition(s, i + 1, list);
                list.remove(list.size() - 1);
//                System.out.println("list so far " + list);

            }
        }
    }
}
