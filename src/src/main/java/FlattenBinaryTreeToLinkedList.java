package src.main.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 * <p>
 * For example,
 * Given
 * <p>
 *       1
 *      / \
 *     2   5
 *    / \   \
 *   3   4   6
 * The flattened tree should look like:
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(PathSum.TreeNode root) {
        if (root == null) return;
        // a list of TreeNode to hold just one TreeNode as the tail
        List<PathSum.TreeNode> tailHolder = new ArrayList<PathSum.TreeNode>();
        root = helper(root, tailHolder);
    }

    public PathSum.TreeNode helper(PathSum.TreeNode root, List<PathSum.TreeNode> tailHolder) {
        if (root.left == null && root.right == null) {
            tailHolder.add(0, root);
            return root;
        } else if (root.left != null && root.right == null) {
            root.right = helper(root.left, tailHolder);
            // very important to nullify the left one, we just need to the right one to make it as a linked list
            root.left = null;
            return root;
        } else if (root.right != null && root.left == null) {
            root.right = helper(root.right, tailHolder);
            return root;
        } else {
            // flatten the right part first, get hold of the tail.
            PathSum.TreeNode temp = helper(root.right, tailHolder);
            PathSum.TreeNode finalTail = tailHolder.get(0);
            // then flatten the left part, assign it the right branch,
            root.right = helper(root.left, tailHolder);
            // nullify the left branch, add the flattened right branch to the tail's right branch,
            root.left = null;
            tailHolder.get(0).right = temp;
            tailHolder.add(0, finalTail);
            return root;
        }

    }
}
