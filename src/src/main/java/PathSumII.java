package src.main.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * <p>
 * For example:
 * Given the below binary tree and sum = 22,
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 * return
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */
public class PathSumII {
    public List<List<Integer>> pathSum(PathSum.TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        helper(root, sum, list, result);
        return result;
    }

    public void helper(PathSum.TreeNode root, int sum, List<Integer> list, List<List<Integer>> result) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                // make a copy of the list, plus the root.val, add them all to the result list.
                List<Integer> temp = new ArrayList(list);
                temp.add(root.val);
                result.add(temp);
            }
        } else {
            // if root is not null, add val to the list
            list.add(root.val); // corresponding to the next remove.
            helper(root.left, sum - root.val, list, result);
            helper(root.right, sum - root.val, list, result);
            // remove the added val after previous add, to backtrack to the previous level.
            list.remove(list.size() - 1); // corresponding to the previous add.
        }
    }
}
