package src.main.java;

/**
 * number 1 .. 26 is A .. Z.
 * number 27 .. 52 is AA .. AZ.
 */
public class ConvertNumberBase26 {
    public String numberToBase26(int num) {
        StringBuffer s = new StringBuffer();
        while(num > 0) {
            int r = num % 26;
            char c = r == 0? 'Z': (char) (r + 'A' -1);
            s.append(c);
            num = (int) Math.ceil(num * 1.0 / 26) - 1;
        }
        return s.reverse().toString();
    }

    public int base26ToNumber(String s) {
        int result = 0;
        int factor = 1;
        for(int i = s.length()-1; i>= 0; i--) {
            char c = s.charAt(i);
            int n = c - 'A' + 1;
            result += n * factor;
            factor *= 26;
        }
        return result;
    }

    public static void main(String[] args) {
        ConvertNumberBase26 cnb = new ConvertNumberBase26();
        System.out.println(cnb.base26ToNumber("AZ"));
        System.out.println(cnb.numberToBase26(34));
    }
}
