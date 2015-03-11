package src.main.java;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * <p>
 * For example:
 * Given binary tree {1,#,2,3},
 * 1
 *  \
 *  2
 * /
 * 3
 * return [1,2,3].
 * <p>
 * Note: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreePreorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> preorderTraversalRecursive(TreeNode root) {
        List<Integer> out = new LinkedList<>();
        helper(root, out);
        return out;
    }

    private void helper(TreeNode root, List<Integer> out) {
        if(root != null) {
            out.add(root.val);
            helper(root.left, out);
            helper(root.right, out);
        }
    }

    public List<Integer> preorderTraversalInterative(TreeNode root) {
        List<Integer> out = new LinkedList<>();
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while(!s.empty()) {
            TreeNode current = s.pop();
            if (current!= null) {
                out.add(current.val);
                s.push(current.right);
                s.push(current.left);
            }
        }
        return out;
    }
}
