package src.main.java;

import java.util.Stack;

/**
 * Created by xiaoyazi on 1/6/15.
 */
public class MinStack {
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> sMin = new Stack<Integer>();

    public void push(int x) {
        if (sMin.size() > 0) {
            if (x <= sMin.peek()) {
                sMin.push(x);
            }
        } else {
            sMin.push(x);
        }
        s1.push(x);
    }

    public void pop() {
        int top = s1.pop();
        if (top == sMin.peek()) {
            sMin.pop();
        }
    }

    public int top() {
        return s1.peek();
    }

    public int getMin() {
        return sMin.peek();
    }
}
