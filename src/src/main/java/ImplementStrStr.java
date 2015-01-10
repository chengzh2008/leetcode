package src.main.java;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyazi on 1/9/15.
 * Implement strStr().
 *
 * Returns the index of the first occurrence of needle in haystack,
 * or -1 if needle is not part of haystack.
 *
 *  this problem can be solved using known efficient algorithms such as
 *  Rabin-Karp algorithm, KMP algorithm, and the Boyer- Moore algorithm.
 */
public class ImplementStrStr {
    public int strStr(String haystack, String needle) {

        int a = haystack.length();
        int b = needle.length();

        if (b==0 || (a== 0 && b==0)) return 0;
        if (b > a) return -1;
        Map<String, Integer> bag = new HashMap<String,Integer>();
        int i = 0;
        String s;
        while(i <= a-b) {
            s = haystack.substring(i, b+i);
            if (!bag.containsKey(s)) bag.put(s, i);
            i++;
        }
        if(bag.containsKey(needle)) return bag.get(needle);
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new ImplementStrStr().strStr("12345", "4"));
    }
}
