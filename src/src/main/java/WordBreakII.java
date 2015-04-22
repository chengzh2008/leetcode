package src.main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 * <p>
 * Return all such possible sentences.
 * <p>
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * <p>
 * A solution is ["cats and dog", "cat sand dog"].
 */
public class WordBreakII {
    // this solution got TLE (time limit exceed)
    public List<String> wordBreak(String s, Set<String> dict) {
        int n = s.length();
        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        getSentence(dict, s, 0, "", res);
        return res;
    }

    private void getSentence(Set<String> dict, String s, int start, String cur, List<String> res) {
        if(start == s.length()) {
            res.add(cur);
            return;
        }
        String substr;
        String nextStr;
        for (int i = start; i<=s.length(); i++) {
            substr = s.substring(start, i);
            if (dict.contains(substr)) {
                nextStr = i == s.length()? cur + substr : cur + substr + " ";
                getSentence(dict, s, i, nextStr, res);
            }
        }
    }

    public List<String> wordBreakRecursiveII(String s, Set<String> dict) {
        int n = s.length();
        List<String> res = new ArrayList<>();
        if (n == 0) return res;

        getSentenceII(dict, s, "", res);

        return res;
    }

    private void getSentenceII(Set<String> dict, String s, String cur, List<String> res) {
        if (s.length() == 0) {
            res.add(cur);
            return;
        }
        String substr;
        for(String word : dict) {
            if (s.startsWith(word)) {
                substr = s.substring(word.length());
                getSentenceII(dict, substr, substr.equals("")? cur + word : cur + word + " ", res);
            }
        }
    }


    public List<String> wordBreakIIDP(String s, Set<String> dict) {
        int n = s.length();
        if (n == 0) return new ArrayList<>();
        Map<String, List<String>> partial = new HashMap<>();
        getSentenceDP(dict, s, partial);
        return partial.get(s);
    }

    private List<String> getSentenceDP(Set<String> dict, String s, Map<String, List<String>> partial) {
        if (partial.containsKey(s)) {
            return partial.get(s);
        }
        List<String> solutionForThisString = new ArrayList<>();
        // base case for recursion.
        if (s.length() == 0) {
            solutionForThisString.add("");
            return solutionForThisString;
        }
        String substr;
        for(String word : dict) {
            if (s.startsWith(word)) {
                substr = s.substring(word.length());
                List<String> nextSolution = getSentenceDP(dict, substr, partial);
                for (String sentence: nextSolution) {
                    if (sentence.length() > 0) {
                        solutionForThisString.add(word + " " + sentence);
                    } else {
                        solutionForThisString.add(word);
                    }
                }
            }
        }
        partial.put(s, solutionForThisString);
        return solutionForThisString;
    }

    public static void main(String[] args) {
        final Set<String> dict = new HashSet<String>(Arrays.asList("cat", "cats", "and", "sand", "dog"));
        WordBreakII wordBreakII = new WordBreakII();
        System.out.println(wordBreakII.wordBreak("catsanddog", dict));
        System.out.println(wordBreakII.wordBreakIIDP("catsanddog", dict));

    }
}
