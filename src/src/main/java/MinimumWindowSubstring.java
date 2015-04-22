package src.main.java;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all
 * the characters in T in complexity O(n).

 For example,
 S = "ADOBECODEBANC"
 T = "ABC"
 Minimum window is "BANC".

 Note:
 If there is no such window in S that covers all characters in T, return the emtpy string "".

 If there are multiple such windows, you are guaranteed that there will always be only one
 unique minimum window in S.
 */
public class MinimumWindowSubstring {
    public String minWindw(String S, String T) {
        if (S.length() == 0 || T.length() > S.length()) return "";
        int[] needToFind = new int[256];
        int[] hasFound = new int[256];

        for(int i = 0; i< T.length(); i++) {
            needToFind[T.charAt(i)]++;
        }
        int minWindow = S.length();
        int minStart =0;
        int minEnd =0;
        int charSoFar = 0;
        int start = 0;
        int end = 0;
        for(;end<S.length(); end++) {
            char last = S.charAt(end);
            if(needToFind[last] > 0) {
                hasFound[last]++;
                if (hasFound[last] <= needToFind[last]) {
                    charSoFar++;
                }
            }
            if (charSoFar == T.length()) {
                char first = S.charAt(start);

                // move the first pointer until you break the constraint
                while(hasFound[first] > needToFind[first] || needToFind[first] == 0) {
                    hasFound[first]--;
                    start++;
                    first = S.charAt(start);
                }
                // update current min window
                if (end-start+1 < minWindow) {
                    minWindow = end-start + 1;
                    minStart = start;
                    minEnd = end;
                }
            }
        }
        return S.substring(minStart, minEnd+1);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        System.out.println("testing...");
        System.out.println(minimumWindowSubstring.minWindw("ADOBECODEBANC", "ABC"));
    }
}
