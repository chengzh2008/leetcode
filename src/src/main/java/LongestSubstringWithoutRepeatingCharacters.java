package src.main.java;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc",
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 *
 * Strategy: two pointers
 * keep a set to hold unique chars between two pointers.
 * keep a int max to remember the longest substring so far.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;
        Set<Character> set = new HashSet<>();
        int i = 0;
        set.add(s.charAt(i));
        int j = 1;
        int max = set.size();
        while(j < s.length()) {
            char left = s.charAt(i);
            char right = s.charAt(j);

            if (!set.contains(right)) {
                set.add(right);
                max = Math.max(max, set.size());
                j++;
            } else {
                if (left == right) {
                    i++;
                    j++;
                } else {
                    while(s.charAt(i) != right) {
                        set.remove(s.charAt(i));
                        i++;
                    }
                    i++;
                    j++;
                }
            }

        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters temp = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(temp.lengthOfLongestSubstring("bbbb"));
        System.out.println(temp.lengthOfLongestSubstring("abcabcd"));
        System.out.println(temp.lengthOfLongestSubstring("abcabcdacefghi"));


    }
}
