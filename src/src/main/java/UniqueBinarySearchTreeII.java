package src.main.java;

import java.util.LinkedList;
import java.util.List;

/**
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

 For example,
 Given n = 3, your program should return all 5 unique BST's shown below.

 1         3     3      2      1
  \       /     /      / \      \
   3     2     1      1   3      2
  /     /       \                 \
 2     1         2                 3
 */
public class UniqueBinarySearchTreeII {
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }

    public List<TreeNode> helper(int m, int n) {
        List<TreeNode> list = new LinkedList<>();
        if (m > n) {
            list.add(null);
            return list;
        }
        for (int i = m; i <= n; i++) {
            List<TreeNode> left = helper(m, i-1);
            List<TreeNode> right = helper(i+1, n);
            for(TreeNode a : left) {
                for(TreeNode b : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = a;
                    root.right = b;
                    list.add(root);
                }
            }
        }
        return list;
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
