package src.main.java;

//Given an integer n, return the number of trailing zeroes in n!.
//
//        Note: Your solution should be in logarithmic time complexity.
//  for example 5! = 5 x 4 x 3 x 2 x 1 = 120 has 1 trailing zero
//              10! = 10 x 9 x 8 x 7 x 6 x 5 x 4 x 3 x 2 x 1 = 3628800
// strategy: simple enought to count how many 10 are there up to interger n
// one thing we have to consider that 2 x 5 is 10. So the problem becomes
// counting how many 5 there, because there are way more even number than 5
// to make a factor of 10, you also need to think about 25 = 5 x 5, and
// 125 = 5 x 5 x 5, and so on.

public class NumTrailingZero {
    public class Solution {
        public int trailingZeroes(int n) {
            int count = 0;
            while (n >=5) {
                count += n/5;
                n /= 5;
            }
            return count;
        }
    }
}
