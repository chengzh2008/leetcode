package src.main.java;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiaoyazi on 4/24/15.
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        if (k > n || n == 0) return result;
        List<Integer> list = new LinkedList<>();
        helper(n, 1, k, list, result);
        return result;
    }

    public void helper(int n, int start, int k, List<Integer> list, List<List<Integer>> result) {
        if (k == 0) {
            List<Integer> temp = new LinkedList<>(list);
            result.add(temp);
            return;
        }
        // try start from 1 to n-k+1 to make k elements in the list.
        for (; start <= n-k +1; start++) {

            list.add(start);
            helper(n, start + 1, k-1, list, result);
            list.remove(list.size() - 1);
        }

    }

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        System.out.println(combinations.combine(2, 1));
    }
}
