package src.main.java;

/**
 * Created by xiaoyazi on 1/11/15.
 * <p/>
 * Reverse digits of an integer.
 * <p/>
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 */
public class ReverseInteger {
    public int reverse(int x) {
        boolean neg = false;
        if (x < 0) {
            neg = true;
            x = -x;
        }
        double sum = 0;
        while (x > 0) {
            sum = sum * 10 + x%10;
            x = x/10;
        }
        if (sum > Integer.MAX_VALUE) return 0;
        return neg? -(int)sum: (int)sum;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(-1534236469));
    }
}
