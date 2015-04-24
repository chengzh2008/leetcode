package src.main.java;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree
 * <p>
 * struct TreeLinkNode {
 * TreeLinkNode *left;
 * TreeLinkNode *right;
 * TreeLinkNode *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * <p>
 * Initially, all next pointers are set to NULL.
 * <p>
 * Note:
 * <p>
 * You may only use constant extra space.
 * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 * For example,
 * Given the following perfect binary tree,
 *     1
 *    /  \
 *   2    3
 *  / \  / \
 * 4  5  6  7
 * After calling your function, the tree should look like:
 *      1 -> NULL
 *    /  \
 *   2 -> 3 -> NULL
 *  / \  / \
 * 4->5->6->7 -> NULL
 */
public class PopulateNextRightPointersEachNode {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        List<TreeLinkNode> list = new LinkedList<>();
        Deque<TreeLinkNode> q = new LinkedList<>();
        TreeLinkNode levelLast = root;
        q.add(root);
        TreeLinkNode cur;
        while(!q.isEmpty()) {
            cur = q.remove();
            list.add(cur);
            if (cur.left != null) {
                q.add(cur.left);
            }
            if (cur.right != null) {
                q.add(cur.right);
            }
            if (cur == levelLast) {
                levelLast = q.peekLast();
                list.get(list.size()-1).next = null;
                if (list.size() > 1) {
                    for (int i = 0; i< list.size()-1; i++) {
                        list.get(i).next = list.get(i+1);
                    }
                }
                list = new ArrayList<>();
            }

        }
    }

    public class TreeLinkNode {
             int val;
             TreeLinkNode left, right, next;
             TreeLinkNode(int x) { val = x; }
         }
}
