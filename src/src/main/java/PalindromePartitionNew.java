package src.main.java;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitionNew {
    public List<List<String>> partition(String s) {
        List<String> output = new ArrayList<String>();
        List<List<String>> result = new ArrayList<List<String>>();
        partitionHelper(s, 0, output, result);
        System.out.println(result);
        return result;
    }

    public void partitionHelper(String s, int start, List<String> output, List<List<String>> result) {
        int n = s.length();
        if (start == n) {
            List<String> list = new ArrayList<>();
            list.addAll(output);
            result.add(list);
            System.out.println(result);
            return;
        }

        for(int i = start; i < n; i++) {
            if (isPalindrame(s, start, i)) {
                output.add(s.substring(start, i+1));
                System.out.println(output);
                partitionHelper(s, i + 1, output, result);
                // tricky part. 
                output.remove(output.size()-1);
            }
        }
    }

    public boolean isPalindrame(String s, int i, int j) {
        while(i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitionNew palindromePartitionNew = new PalindromePartitionNew();
        System.out.println(palindromePartitionNew.partition("a"));
    }
}