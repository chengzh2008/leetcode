package src.main.java;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * <p>
 * For example:
 * Given "25525511135",
 * <p>
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 *
 * Strategy: recursive backtracking
 *
 * start from index 0, scan the ip string. take the substring of length 1, 2 and 3
 * for length 2 number, if the number is valid (not begin with '0'), call recursively.
 * for length 3 number, if the number is valid (not begin with '0' and not bigger than 255),
 * call recursively.
 *
 *
 *
 */
public class RestoreIPAddress {
    public List<String> restoreIpAddress(String ip) {
        List<List<String>> result = new LinkedList<>();
        List<String> output = new LinkedList<>();

        List<String> list = new LinkedList<>();
        helper(ip, 0, list, result);
        // convert list to a string
        for(List<String>  ipStrings : result) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i< ipStrings.size(); i++) {
                sb.append(ipStrings.get(i));
                if (i != ipStrings.size()-1) {
                    sb.append(".");
                }
            }
            output.add(sb.toString());
        }
        return output;
    }

    private void helper(String ip, int start, List<String> list, List<List<String>> result) {
        if (list.size() >=4 && start < ip.length()) {
            return;
        }
        if (list.size() == 4 && start == ip.length()) {
            List<String>  newList = new LinkedList<>();
            newList.addAll(list);
            result.add(newList);
            return;
        }
        if (start <= ip.length()-3) {
            String sub3 = ip.substring(start, start+3);
            if (sub3.charAt(0) != '0' && Integer.parseInt(sub3) <= 255) {
                list.add(sub3);
                helper(ip, start+3, list, result);
                list.remove(list.size()-1);
            }
        }
        if (start <= ip.length()-2) {
            String sub2 = ip.substring(start, start+2);
            if (sub2.charAt(0) != '0') {
                list.add(sub2);
                helper(ip, start + 2, list, result);
                list.remove(list.size() - 1);
            }
        }
        if (start <= ip.length()-1) {
            String sub1 = ip.substring(start, start + 1);
            list.add(sub1);
            helper(ip, start + 1, list, result);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        RestoreIPAddress restoreIPAddress = new RestoreIPAddress();
        System.out.println(restoreIPAddress.restoreIpAddress("25525511135"));
        System.out.println(restoreIPAddress.restoreIpAddress("010010"));

    }
}
