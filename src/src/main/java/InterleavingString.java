package src.main.java;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * <p>
 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 * <p>
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 */
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        // if length of s3 is not the sum of lengths A and B
        if (m + n != s3.length()) {
            return false;
        }
        // create a 2D table to record solutions of subproblems. sub[i][j] will be true if
        // s3[0.. i+j-1] is an interleaving of s1[0..i-1] and s2[0..j-1].
        boolean[][] sub = new boolean[m + 1][n + 1];
        // two empty strings interleave to for an empty string
        sub[0][0] = true;
        // if s2 is empty
        for (int i = 1; i <= m; i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1)) {
                sub[i][0] = sub[i - 1][0];
            }
        }
        // if s1 is empty
        for (int j = 1; j <= n; j++) {
            if (s2.charAt(j - 1) == s3.charAt(j - 1)) {
                sub[0][j] = sub[0][j - 1];
            }
        }
        // process all chars of s1 and s2
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                // if current char of s3 matches that of s1 but not s2
                if (s1.charAt(i - 1) == s3.charAt(i + j - 1) && s2.charAt(j - 1) != s3.charAt(i + j - 1)) {
                    sub[i][j] = sub[i - 1][j];
                }
                // if current char of s3 matches that of s2 but not s1
                if (s2.charAt(j - 1) == s3.charAt(i + j - 1) && s1.charAt(i - 1) != s3.charAt(i + j - 1)) {
                    sub[i][j] = sub[i][j - 1];
                }
                if (s1.charAt(i - 1) == s3.charAt(i + j - 1) && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    sub[i][j] = (sub[i - 1][j] || sub[i][j - 1]);
                }
            }
        }
        return sub[m][n];
    }

    public static void main(String[] args) {
        InterleavingString interleavingString = new InterleavingString();
        System.out.println(interleavingString.isInterleave("a", "", "c"));
        System.out.println(interleavingString.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(interleavingString.isInterleave("aabcc", "dbbca", "aadbbbaccc"));


    }

}
