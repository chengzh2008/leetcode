package src.main.java;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of numbers, return all possible permutations.
 * <p>
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 *
 * Strategy: Recursive backtracking...
 *
 * Basically, for each item in the array, you add item, which is not in the
 * list so far, to the growing list, until you get all the items.
 *
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        // list of list to hold the result
        List<List<Integer>> result = new LinkedList<>();
        // list of integer to hold current growing list
        List<Integer> list = new LinkedList<>();
        // recursive call from 0
        helper(nums, 0, list, result);
        return result;
    }

    public void helper(int[] nums, int start, List<Integer> list, List<List<Integer>> result) {
        // if reach to the total number, add the current list to the result
        if (start == nums.length) {
            // create a copy of the growing list, add the copy to the result, because here
            // we need backtracking...
            List<Integer> newList = new LinkedList<>();
            newList.addAll(list);
            result.add(newList);
            return;
        }
        // then, for each item not in the list, we add it to the list and make a recursive call
        for(int i = 0; i< nums.length; i++) {
            int cur = nums[i];
            if (!list.contains(cur)) {
                list.add(cur);
                helper(nums, start+1, list, result);
                list.remove(list.size()-1);
            }
        }
    }
}
