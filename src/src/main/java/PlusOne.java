package src.main.java;

/**
 * Created by xiaoyazi on 1/8/15.
 * Given a non-negative number represented as an array of digits, plus one to the number.

 The digits are stored such that the most significant digit is at the head of the list.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (isAll9(digits)) {
            int[] out = new int[digits.length + 1];
            out[0] = 1;
            return out;
        } else {
            int i = digits.length-1;
            while(i>=0) {
                if (digits[i] <9) {
                    digits[i]++;
                    return digits;
                } else {
                    digits[i] = 0;
                    i--;
                }
            }
            return digits;
        }
    }

    private boolean isAll9(int[] digits) {
        for (int i : digits) {
            if (i != 9) return false;
        }
        return true;
    }
}
