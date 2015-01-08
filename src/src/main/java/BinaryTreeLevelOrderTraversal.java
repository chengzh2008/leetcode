package src.main.java;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiaoyazi on 1/7/15.
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * <p/>
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its level order traversal as:
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (root == null) return lists;
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        deque.add(root);
        TreeNode levelLast = root;
        List<Integer> list = new ArrayList<Integer>();
        while (deque.size() > 0) {
            TreeNode current = deque.pop();
            list.add(current.val);
            if (current.left != null) deque.add(current.left);
            if (current.right != null) deque.add(current.right);
            if (current == levelLast) {
                lists.add(list);
                list = new ArrayList<Integer>();
                levelLast = deque.peekLast();
            }
        }
        return lists;
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
