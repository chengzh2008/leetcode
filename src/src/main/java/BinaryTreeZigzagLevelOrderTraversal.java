package src.main.java;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 * <p>
 * For example:
 * Gi en binary tree {3,9,20,#,#,15,7},
 *      3
 *     / \
 *    9  20
 *  /  \
 * 15   7
 * return its zigzag level order traversal as:
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        TreeNode current;
        List<Integer> list;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.add(root);
        while(!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty()) {
                list = new LinkedList<>();
                while(!s1.isEmpty()) {
                    current = s1.pop();
                    list.add(current.val);
                    if (current.left != null) {
                        s2.push(current.left);
                    }
                    if (current.right != null) {
                        s2.push(current.right);
                    }
                }
                result.add(list);
            }
            if (!s2.isEmpty()) {
                list = new LinkedList<>();
                while(!s2.isEmpty()) {
                    current = s2.pop();
                    list.add(current.val);
                    if (current.right != null) s1.push(current.right);
                    if (current.left != null) s1.push(current.left);
                }
                result.add(list);
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
