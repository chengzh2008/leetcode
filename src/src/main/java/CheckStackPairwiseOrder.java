package src.main.java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Given a stack of integers, how do check whether each successive pair of numbers in the stack
 * is consecutive or not. The pairs can be increasing or decreasing, and if the stack has an odd
 * number of elements, the element at the top is left out of a pair. For example, if the stack of
 * elements are [4, 5, -2, -3, 11, 10, 5, 6, 20]
 *
 * Basically you have to reverse the numbers in the stack to check from the bottom to void the
 * odd/even check.
 *
 *
 */
public class CheckStackPairwiseOrder {
    public static boolean isPairwiseOrder(Stack<Integer> s) {
        Queue<Integer> q = new LinkedList<>();
        boolean isPairwiseOrder = true;
        while(!s.isEmpty()) q.add(s.pop());
        while(!q.isEmpty()) s.push(q.remove());
        while(!s.isEmpty()) {
            int m = s.pop();
            q.add(m);
            if (!s.isEmpty()) {
                int n = s.pop();
                q.add(n);
                if (Math.abs(m-n) != 1) {
                    isPairwiseOrder = false;
                }
            }
        }
        while(!q.isEmpty()) {
            s.push(q.remove());
        }
        return isPairwiseOrder;
    }
}
