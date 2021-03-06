package src.main.java;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * <p>
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * <p>
 * Find the total sum of all root-to-leaf numbers.
 * <p>
 * For example,
 * <p>
 * 1
 * / \
 * 2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * <p>
 * Return the sum = 12 + 13 = 25.
 */
public class SumRootToLeafNumbers {
    public int sumNumbers(PathSum.TreeNode root) {
        // need an object here to convey the sum back to the caller
        int[] sum = new int[1];
        String digits = "";
        helper(root, digits, sum);
        return sum[0];
    }

    public void helper(PathSum.TreeNode root, String digits, int[] sum) {
        if (root == null) return;
        String newDigits = digits + root.val;
        if (root.left == null && root.right == null) {
            // inside the recursive method, increment the num stored in the single element sum array
            sum[0] += Integer.parseInt(newDigits);
        } else {
            helper(root.left, newDigits, sum);
            helper(root.right, newDigits, sum);
        }
    }
}
