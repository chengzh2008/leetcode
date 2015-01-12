package src.main.java;

/**
 * Created by xiaoyazi on 1/11/15.
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a
 * given number of rows like this: (you may want to display this pattern
 * in a fixed font for better legibility)
 * <p/>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p/>
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class ZigZagSring {
    public String convert(String s, int nRows) {
        if (nRows == 1)
            return s;
        StringBuilder strBuilder = new StringBuilder();
        int borderRowStep = 2 * nRows - 2;
        for (int i = 0; i < nRows; i++) {
            if (i == 0 || i == nRows - 1) {
                for (int j = i; j < s.length(); j = j + borderRowStep) {
                    strBuilder.append(s.charAt(j));
                }
            } else {
                int j = i;
                boolean flag = true;
                int insideRowLargeStep = 2 * (nRows - 1 - i);
                int insideRowSmallStep = borderRowStep - insideRowLargeStep;
                while (j < s.length()) {
                    strBuilder.append(s.charAt(j));
                    if (flag)
                        j = j + insideRowLargeStep;
                    else
                        j = j + insideRowSmallStep;
                    flag = !flag;
                }
            }
        }
        return strBuilder.toString();

    }
}
