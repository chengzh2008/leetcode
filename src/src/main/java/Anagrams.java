package src.main.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, return all groups of strings that are anagrams.
 * <p>
 * Note: All inputs will be in lower-case.
 * <p>
 * Show Tags
 */
public class Anagrams {
    public List<String> anagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<String> result = new LinkedList<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sorted = new String(charArray);
            if (map.containsKey(sorted)) {
                map.get(sorted).add(str);
            } else {
                map.put(sorted, new LinkedList<>());
                map.get(sorted).add(str);
            }
        }

        for (List<String> list : map.values()) {
            if (list.size() > 1) {
                result.addAll(list);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Anagrams anagrams = new Anagrams();
        String[] arr = {"ab", "ab"};
        System.out.println(anagrams.anagrams(arr));
    }
}
