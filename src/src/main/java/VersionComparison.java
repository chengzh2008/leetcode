package src.main.java;

/**
 * Created by xiaoyazi on 1/6/15.
 */
public class VersionComparison {
    public class Solution {
        public int compareVersion(String version1, String version2) {
            String[] string1 = version1.split("\\.");
            String[] string2 = version2.split("\\.");
            int length = Math.max(string1.length, string2.length);
            for (int i = 0; i < length; i++) {
                Integer v1 = i < string1.length ? Integer.parseInt(string1[i]) : 0;
                Integer v2 = i < string2.length ? Integer.parseInt(string2[i]) : 0;
                int compare = v1.compareTo(v2);
                if (compare != 0) {
                    return compare;
                }
            }
            return 0;
        }
    }
}
