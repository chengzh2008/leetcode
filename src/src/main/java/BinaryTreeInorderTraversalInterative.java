package src.main.java;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * <p>
 * For example:
 * Given binary tree {1,#,2,3},
 * 1
 *  \
 *   2
 *  /
 * 3
 * return [1,3,2].
 * <p>
 * Note: Recursive solution is trivial, could you do it iteratively?
 * <p>
 * confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 *
 *
 * Strategy:
 * Use a stack to push every left branch node start from the root to the stack, then
 * deal with each node from the stack. If it has right branch, repeat the previous step,
 * looks like the treat the right branch as a new root with the same process.
 *
 *
 */
public class BinaryTreeInorderTraversalInterative {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        boolean done = false;
        while(!done) {
            // push all the left node to the stack.
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                // pop the node, output the interger, and deal with its right node
                if (!stack.isEmpty()) {
                    current = stack.pop();
                    result.add(current.val);
                    // push the right node to the stack
                    current = current.right;
                } else {
                    // when current is null and stack is empty, complete the task.
                    done = true;
                }
            }
        }
        return result;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
