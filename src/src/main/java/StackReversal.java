package src.main.java;

import java.util.Stack;

/**
 * Given a stack, ow to reverse the contents of stacks using only stack operations
 * (push and pop).
 *
 * Strategy. Think about recursive.
 *
 * you take the pop the top element, and reverse the stack, then put the popped element
 * back to the bottom of the stack.
 *
 * But how do you insert an element into the bottom of a stack? Same strategy! You pop
 * the top element, reduce the size of the stack, then you insert the element into the
 * bottom of the shorter stack, then push back the popped item.
 */
public class StackReversal {
    public static void reverseStack(Stack<String> s) {
        if (s.isEmpty()) return;
        String top = s.pop();
        reverseStack(s);
        insertBottom(s, top);
    }

    private static void insertBottom(Stack<String> s, String data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        String top = s.pop();
        insertBottom(s, data);
        s.push(top);
    }

    public static void main(String[] args) {
        Stack<String> s = new Stack<>();
        s.push("A");
        s.push("B");
        s.push("C");
        System.out.println(s.toString());
        reverseStack(s);
        System.out.println(s.toString());

    }
}
