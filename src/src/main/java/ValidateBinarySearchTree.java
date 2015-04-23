package src.main.java;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * Strategy: be ware of the edge case.
 * if one of the node val is Integer.MAX_VALUE or Integer.MIN_VALUE.
 *
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(PathSum.TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(PathSum.TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        if (min != null && min.compareTo(root.val) >= 0) return false;
        if (max != null && max.compareTo(root.val) <= 0) return false;
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }


}
