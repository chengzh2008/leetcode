package src.main.java;

import java.util.Stack;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator
 * will be initialized with the root node of a BST.
 * <p>
 * Calling next() will return the next smallest number in the BST.
 * <p>
 * Note: next() and hasNext() should run in average O(1) time and uses O(h)
 * memory, where h is the height of the tree.
 * <p>
 * <p>
 * <p>
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 *
 *
 * Strategy:
 * There is a restriction memory O(h). Thinking of a stack to store the parent node
 * from which we can retrieve the smallest number.
 * for example:
 *          A
 *        /   \
 *       B     C
 *      / \
 *     D   E
 *    / \
 *   F   G
 *      / \
 *     H   I
 *
 * we traversal the tree from A, and push A, B, D, F onto the stack.
 * stack: bottom[A,B,D,F]top
 * we call next(), pop the top node F, and return its val
 * then we call next(), which pops the top node D. In this case, there are children nodes in the D,
 * we need to store its children nodes onto the stack like we start at the beginning A
 * thus, stack: bottom[A,B,G,H]top
 *
 *
 *
 */

public class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode curr = root;
        while(curr != null) {
            stack.push(curr);
            if (curr.left != null) {
                curr= curr.left;
            } else {
                break;
            }
        }
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode node = stack.pop();
        TreeNode curr = node;
        // process its right node
        if (curr.right != null) {
            curr = curr.right;
            while(curr!=null) {
                stack.push(curr);
                if (curr.left!=null) {
                    curr= curr.left;
                } else {
                    break;
                }
            }
        }
        return node.val;
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
