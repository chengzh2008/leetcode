package src.main.java;

/**
 * Created by xiaoyazi on 1/11/15.
 * <p/>
 * Implement atoi to convert a string to an integer.
 * <p/>
 * Hint: Carefully consider all possible input cases. If you want a
 * challenge, please do not see below and ask yourself what are the possible input cases.
 * <p/>
 * Notes: It is intended for this problem to be specified vaguely (ie,
 * no given input specs). You are responsible to gather all the input
 * requirements up front.
 * <p/>
 * <p/>
 * Requirements for atoi:
 * The function first discards as many whitespace characters as necessary
 * until the first non-whitespace character is found. Then, starting from
 * this character, takes an optional initial plus or minus sign followed by
 * as many numerical digits as possible, and interprets them as a numerical value.
 * <p/>
 * The string can contain additional characters after those that form the
 * integral number, which are ignored and have no effect on the behavior of
 * this function.
 * <p/>
 * If the first sequence of non-whitespace characters in str is not a valid
 * integral number, or if no such sequence exists because either str is empty
 * or it contains only whitespace characters, no conversion is performed.
 * <p/>
 * If no valid conversion could be performed, a zero value is returned. If the
 * correct value is out of the range of representable values, INT_MAX (2147483647)
 * or INT_MIN (-2147483648) is returned.
 */
public class StringToInteger {
    public int atoi(String str) {
        if (str == null || str.length() == 0) return 0;
        String s1 = str.replaceAll("[^\\d]", "").trim();
        int index = str.indexOf(s1);
        if (index >= 2) {
            char c1 = str.charAt(index-2);
            char c2 = str.charAt(index-1);
            if (c1 == c2 ) {
                if (c1 == '-') s1 = '-' + s1;
            } else {

            }
        }
        if (s1.length() == 0) return 0;
        // if s contains more than 1 '-'
        while(s1.length() > 1) {
            if (s1.charAt(1) == '-') {
                s1 = s1.substring(1);
            } else {
                break;
            }
        }
        if (s1.length() ==1 && s1.charAt(0)=='-') return 0;
        double out = Double.valueOf(s1);
        if (out > Integer.MAX_VALUE ) return Integer.MAX_VALUE;
        if (out < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) out;
    }

    public static void main(String[] args) {
        System.out.println(new StringToInteger().atoi("+-5"));
    }

}
