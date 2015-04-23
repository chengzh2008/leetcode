package src.main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.
 * <p>
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,2], a solution is:
 * <p>
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 *
 * Strategy:
 * bottom-up. get all list of the previous i elements, then add i+1 element to the previous
 * lists. check if it is already there, if so, do not add, otherwise add to the list.
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        if (num == null) return null;

        List<List<Integer>> result = new ArrayList<>();
        // add empty list
        result.add(new ArrayList<>());
        // sort the num array to make sure it is in order
        Arrays.sort(num);
        for(int i : num) {
            // for every i, create a lists of list contains i
            List<List<Integer>> temp = new ArrayList<>();
            // for every list found so far in the lists:
            for (List<Integer> subset: result) {
                // create a copy of that
                List<Integer> cur = new ArrayList<>(subset);
                cur.add(i);
                if (!result.contains(cur)) {
                    temp.add(cur);
                }
            }
            // add lists of element related to current i element back to the result
            result.addAll(temp);
        }
        return result;
    }

    public static void main(String[] args) {
        SubsetsII subsetsII = new SubsetsII();
        int[] arr = {2, 1, 2};
        System.out.println(subsetsII.subsetsWithDup(arr));
    }



}
