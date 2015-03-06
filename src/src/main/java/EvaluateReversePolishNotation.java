package src.main.java;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 *
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        String operator = "+-*/";
        Stack<Integer> s = new Stack<>();
        for (String item : tokens) {
            if (!operator.contains(item)) {
                s.push(Integer.parseInt(item));
            } else {
                int b = s.pop();
                int a = s.pop();
                switch (operator.indexOf(item)) {
                    case 0:
                        s.push(a + b);
                        break;
                    case 1:
                        s.push(a-b);
                        break;
                    case 2:
                        s.push(a * b);
                        break;
                    case 3:
                        s.push(a/b);
                        break;
                }
            }
        }
        return s.pop();
    }

    public static void main(String[] args) {
        String[] s1 = {"2", "1", "+", "3", "*"};
        String[] s2 = {"4", "13", "5", "/", "+"};

        EvaluateReversePolishNotation evaluateReversePolishNotation = new EvaluateReversePolishNotation();
        System.out.println("s1 = [" + evaluateReversePolishNotation.evalRPN(s1) + "]");
        System.out.println("s2 = [" + evaluateReversePolishNotation.evalRPN(s2) + "]");

    }
}
