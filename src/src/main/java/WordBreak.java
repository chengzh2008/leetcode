package src.main.java;

import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * <p>
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 * <p>
 * Return true because "leetcode" can be segmented as "leet code".
 */
public class WordBreak {
    public boolean wordBreak(String s, Set<String> dict) {
        return wordBreakHelper(s, dict, 0);
    }

    // this method is slow, need to try other strategy, like dynamic programming.
    private boolean wordBreakHelper(String s, Set<String> dict, int start) {
        if (start== s.length()) {
            return true;
        }

        for(String a : dict) {
            int len = a.length();
            int end = len + start;

            if (end > s.length()) {
                continue; // pass this word, try next one
            }

            if (s.substring(start, end).equals(a)) {
                if(wordBreakHelper(s, dict, end)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean wordBreakDP(String s, Set<String> dict) {
        // initialize an array
        boolean[] t = new boolean[s.length() + 1];
        t[0]= true; // initial state

        for (int i = 0; i< s.length(); i++) {
            if(!t[i]) continue;
            for(String a : dict) {
                int len = a.length();
                int end = len + i;
                if (end > s.length()) continue; // consider next word
                if (t[end]) continue; // if already show match
                if (s.substring(i, end).equals(a)) {
                    t[end] = true;
                }
            }
        }
        return t[s.length()];
    }
}
