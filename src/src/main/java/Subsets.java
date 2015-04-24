package src.main.java;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a set of distinct integers, S, return all possible subsets.
 * <p>
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,3], a solution is:
 * <p>
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> result = new LinkedList<>();
        result.add(new LinkedList<Integer>());
        // edge case...
        if (S == null || S.length ==0) return result;
        Arrays.sort(S);
        helper(S, 0, result);
        return result;
    }

    public void helper(int[] arr, int start, List<List<Integer>> result) {
        if (start == arr.length) {
            return;
        }
        List<List<Integer>> newLists = new LinkedList<>();
        List<Integer> temp;
        // for every list in the result, add the current element into it, make a new list of list containing current element.
        for(List<Integer> cur : result) {
            temp = new LinkedList(cur);
            temp.add(arr[start]);
            newLists.add(temp);
        }
        // add the newly created lists of list to the result list.
        result.addAll(newLists);
        helper(arr, start+1, result);
    }
}
