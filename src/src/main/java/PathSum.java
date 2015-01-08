package src.main.java;

/**
 * Created by xiaoyazi on 1/6/15.
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        } else {
            int newSum = sum - root.val;
            if (root.left == null && root.right == null) {
                if (newSum == 0) return true;
            }
            return hasPathSum(root.left, newSum) || hasPathSum(root.right, newSum);
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
