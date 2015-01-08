package src.main.java;

/**
 * Created by xiaoyazi on 1/7/15.
 * Given a binary tree, determine if it is height-balanced.

 For this problem, a height-balanced binary tree is defined
 as a binary tree in which the depth of the two subtrees of
 every node never differ by more than 1.
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return (maxDepth(root) - minDepth(root)) <= 1;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    private int minDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
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
