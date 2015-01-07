package src.main.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyazi on 1/6/15.
 * Given an index k, return the kth row of the Pascal's triangle.

 For example, given k = 3,
 Return [1,3,3,1].

 Note:
 Could you optimize your algorithm to use only O(k) extra space?
 */
public class PascalTriangle {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> list0 = new ArrayList<Integer>();
        list0.add(1);
        lists.add(0, list0);
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(1);
            List<Integer> previous = lists.get(i-1);
            for (int j = 1; j < previous.size(); j++) {
                list.add(previous.get(j) + previous.get(j-1));
            }
            list.add(1);
            lists.add(list);
        }
        return lists.get(rowIndex);
    }

    public static void main(String[] args) {
        PascalTriangle p = new PascalTriangle();
        System.out.println(p.getRow(5));
    }
}
