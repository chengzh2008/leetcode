package src.main.java;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xiaoyazi on 1/7/15.
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

 For example:
 Given binary tree {3,9,20,#,#,15,7},
    3
    / \
    9  20
       /  \
      15   7
 return its bottom-up level order traversal as:
 [
 [15,7],
 [9,20],
 [3]
 ]
 *
 */
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Stack<List<Integer>> stack = new Stack<List<Integer>>();
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
                stack.push(list);
                list = new ArrayList<Integer>();
                levelLast = deque.peekLast();
            }
        }
        while(!stack.isEmpty()) {
            lists.add(stack.pop());
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

