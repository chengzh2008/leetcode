package src.main.java;

/**
 * Created by xiaoyazi on 1/9/15.
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * <p/>
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * <p/>
 * Note: The sequence of integers will be represented as a string.
 *
 *
 * Strategy: Basically it is a dynamic programming problem. You need (n-1)th string
 * to generate nth string. Seed 1st and 2nd string directly, programming for n >= 3
 * as below.
 */
public class CountAndSay {
    public String countAndSay(int n) {
        // seeds 1st and 2nd directly
        if (n == 1) return "1";
        if (n == 2) return "11";
        // store each char and convert to string when finished
        StringBuilder stringBuilder = new StringBuilder();
        // start from n = 3
        int i = 3;
        // set previous string
        String previous = "11";
        while (i <= n) {
            // start to process previous string to generate current string
            int index = 1; // char scanning index
            char previousItem = previous.charAt(index - 1); // remember previous char
            int count = 1; // set counter for the previous char
            // loop though the whole previous string start from 2nd char (index = 1)
            while (index < previous.length()) {
                char currentItem = previous.charAt(index);
                // if current char is the same as previous char, increment count and index
                if (currentItem == previousItem) {
                    count++;
                    index++;
                } else {
                    // if not same, put count and previous char into string builder
                    stringBuilder.append((char) (count + '0'));
                    stringBuilder.append(previousItem);
                    // reset count for next char
                    count = 1;
                    previousItem = currentItem; //update previous char
                    index++;
                }
                // if reach to the end of the string, store count and char into string builder
                if (index == previous.length()) {
                    stringBuilder.append((char) (count + '0'));
                    stringBuilder.append(previousItem);
                }
            }
            previous = stringBuilder.toString(); // update previous string
            stringBuilder = new StringBuilder(); // reset string builder for next string
            i++; // increment i to keep going...
        }
        return previous;
    }

    public static void main(String[] args) {
        CountAndSay countAndSay = new CountAndSay();
        System.out.println(countAndSay.countAndSay(6));
    }
}
