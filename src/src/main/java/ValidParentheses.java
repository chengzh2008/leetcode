package src.main.java;

import java.util.Stack;

/**
 * Created by xiaoyazi on 1/10/15.
 * Given a string containing just the characters '(', ')',
 * '{', '}', '[' and ']', determine if the input string is valid.
 *
 * The brackets must close in the correct order, "()" and "()[]{}"
 * are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        String left = "{[(";
        String right = "}])";
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i< s.length(); i++) {
            char c = s.charAt(i);
            if (left.indexOf(c) >= 0) stack.push(c);
            else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (left.indexOf(top) != right.indexOf(c)) return false;
            }
        }
        if (!stack.isEmpty()) return false;
        return true;
    }

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid("((({{}})))"));
        System.out.println(validParentheses.isValid("((({{)))"));
        System.out.println(validParentheses.isValid("((({{))}})"));
        System.out.println(validParentheses.isValid("()"));

    }
}
