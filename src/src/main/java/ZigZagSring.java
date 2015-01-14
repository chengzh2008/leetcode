package src.main.java;

/**
 *
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
 *
 * Strategy:
 * 0        8          16           24
 * 1     7  9       15 17        23
 * 2    6  10     14   18     22
 * 3  5    11  13      19  21
 * 4       12          20
 *
 * after writing this pattern, you may come up an idea. we can see there are two loops: outer
 * loop i from 0 to nRows (here nRows == 5), inner loops j from i to (2*nRows -2) for border
 * loops (i = 0 and i = nRows -1), j from i to 2 * (nRows - 1 - i) or 2 * i alternatively.
 *
 *
 */
public class ZigZagSring {
    public String convert(String s, int nRows) {
        if (nRows == 1) return s;
        StringBuilder stringBuilder = new StringBuilder();
        // step for first row and last row
        int endOutLoopStep = 2 * nRows - 2;
        int innerLoopLargeStep, innerLoopSmallStep;
        for (int i = 0; i< nRows; i++) {
            if (i == 0 || i == nRows-1) {
                for (int j = i; j < s.length(); j += endOutLoopStep) {
                    stringBuilder.append(s.charAt(j));
                }
            } else {
                // steps in the inner loop: first step and second step
                innerLoopLargeStep = endOutLoopStep - 2 * i;
                innerLoopSmallStep = 2 * i;
                boolean flagForAlternativeStepInnerLoop = true;
                for (int j = i; j< s.length();) {
                    stringBuilder.append(s.charAt(j));
                    j += flagForAlternativeStepInnerLoop ? innerLoopLargeStep: innerLoopSmallStep;
                    flagForAlternativeStepInnerLoop = !flagForAlternativeStepInnerLoop;
                }
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        ZigZagSring zigZagSring = new ZigZagSring();
        System.out.println(zigZagSring.convert("PAYPALISHIRING", 3));
    }
}
