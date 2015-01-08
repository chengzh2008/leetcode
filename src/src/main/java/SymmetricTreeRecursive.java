package src.main.java;

/**
 * Created by xiaoyazi on 1/7/15.
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

 For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
 3  4 4  3
 But the following is not:
   1
  / \
 2   2
  \   \
  3    3
 Note:
 Bonus points if you could solve it both recursively and iteratively.

Recursive method.
create a private method taking two node to check this two node are mirror or not
 */
public class SymmetricTreeRecursive {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    // check if left and right are mirror with each other
    private Boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if ((left != null && right == null) || (left == null && right != null)) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
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
