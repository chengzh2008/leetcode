package src.main.java;

/**
 * Created by xiaoyazi on 1/7/15.
 * Given a binary tree, find its minimum depth.
 * <p/>
 * The minimum depth is the number of nodes along the shortest
 * path from the root node down to the nearest leaf node.
 */
public class MinimumDepthBinaryTree {
    public int minDepth(TreeNode root) {
        return helper(root, 1);
    }

    private int helper(TreeNode root, int i) {
        if (root == null) {return 0;}
        else {
            if (root.left == null && root.right == null) {
                return i;
            }
            if (root.left == null && root.right != null)
                return helper(root.right, i + 1);
            if (root.right == null && root.left != null)
                return helper(root.left, i + 1);
            return Math.min(helper(root.left, i + 1), helper(root.right, i + 1));
        }

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
