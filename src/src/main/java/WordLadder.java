package src.main.java;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
 * <p>
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example,
 * <p>
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * <p>
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * <p>
 * Note:
 * <p>
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        if (beginWord == null || endWord == null || wordDict == null || wordDict.size() == 0) return 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        wordDict.remove(beginWord);
        int length = 1;
        while (!queue.isEmpty()) {
            int count = queue.size();
            // check each adjacent string for next exploration
            for (int i = 0; i < count; i++) {
                String cur = queue.poll();
                // for each string, generate its neighbor string and put to queue if it exists in the dict
                for (int j = 0; j < cur.length(); j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == cur.charAt(j)) {
                            continue;
                        }
                        String newString = cur.substring(0, j) + c + cur.substring(j+1, cur.length());
                        if(newString.equals(endWord)) {
                            //System.out.println("get the target " + endWord);
                            return length + 1;
                        }
                        if (wordDict.contains(newString)) {
                            //System.out.println("current new strings " + newString);
                            queue.add(newString);
                            wordDict.remove(newString);
                        }
                    }
                }
            }
            length++;
        }
        return 0;
    }

    public static void main(String[] args) {
        WordLadder wordLadder = new WordLadder();
        Set<String> wordDict = new HashSet<>();
        String[] strings = {"hot","dot","dog","lot","log"};
        for (int i = 0; i< strings.length; i++) {
            wordDict.add(strings[i]);
        }
        System.out.println(wordLadder.ladderLength("hit", "hat", wordDict));
    }
}
