package src.main.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyazi on 1/6/15.
 */
public class PascalTriangleII {
    public List<List<Integer>> getLists(int rowIndex) {
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
        lists.remove(lists.size()-1);
        if (rowIndex ==0) return new ArrayList<List<Integer>>();
        else return lists;
    }

    public static void main(String[] args) {
        PascalTriangleII p = new PascalTriangleII();
        System.out.println(p.getLists(5));
        System.out.println(p.getLists(0));

    }
}
