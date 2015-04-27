package src.main.java;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

 For example, given the following triangle
 [
 [2],
 [3,4],
 [6,5,7],
 [4,1,8,3]
 ]
 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 */
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        if (row == 0) return 0;
        int[] minSum = new int[row];
        minSum[0] = triangle.get(0).get(0);
        for (int i = 1; i< row; i++) {
            List<Integer> current = triangle.get(i);
            int min = Integer.MAX_VALUE;
            for(int x : current) {
                if (x < min) {
                    min = x;
                }
            }
            minSum[i] = minSum[i-1] + min;
        }
        return minSum[row-1];

    }

    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        Integer[] arr1 = {-1};
        Integer[] arr2 = {2, 3};
        Integer[] arr3 = {1,-1, -3};
        List<Integer> list1 = Arrays.asList(arr1);
        List<Integer> list2 = Arrays.asList(arr2);
        List<Integer> list3 = Arrays.asList(arr3);

        List<List<Integer>> lists = new LinkedList<>();
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        System.out.println(triangle.minimumTotal(lists));
    }
}
