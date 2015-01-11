package src.main.java;

import java.util.Arrays;

/**
 * Created by xiaoyazi on 1/10/15.
 * Write a function to find the longest common prefix string
 * amongst an array of strings.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        Arrays.sort(strs);
        int index = 0;
        String first = strs[0];
        String last = strs[strs.length-1];
        int len = Math.min(first.length(), last.length());
        while (index < len && first.charAt(index) == last.charAt(index)) index++;
        return first.substring(0, index);
    }
}
