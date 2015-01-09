package src.main.java;

/**
 * Created by xiaoyazi on 1/8/15.
 * You are climbing a stair case. It takes n steps to reach to the top.

 Each time you can either climb 1 or 2 steps. In how many distinct ways
 can you climb to the top?
 */
public class ClimbingStairs {
    // take long long time because of the recursive
    public int climbStairsRecursive(int n) {
        if (n == 0) return 1;
        if (n < 0 )  return 0;
        return climbStairsRecursive(n-1) + climbStairsRecursive(n-2);
    }

    // dynamic programming (DP) cache the smaller problems
    public int climbStairs(int n) {
        int a = 1;
        int b = 2;
        int c = 0;

        if (n == 1) return 1;
        if (n == 2 )  return 2;
        int i = 3;
        while(i <= n) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

}
