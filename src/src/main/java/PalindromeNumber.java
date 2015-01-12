package src.main.java;

/**
 * Created by xiaoyazi on 1/11/15.
 * <p/>
 * Determine whether an integer is a palindrome. Do this without extra space.
 *
 * Stategy: get left digit, and right digit, compare if they are the same, if yes,
 * chop first and last digit and repeat the step, if not return false;
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        // get div to get the first digit
        int div = 1;
        while (x / div >= 10) {
            div *= 10;
        }
        while (x > 0) {
            int l = x / div;
            int r = x % 10;
            if (l != r) return false;
            x = x % div / 10;
            div /= 100;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromeNumber().isPalindrome(3334333));
    }
}
