package src.main.java;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 * |start  |       |       |       |       |       |       |
 * |       |       |       |       |       |       |       |
 * |       |       |       |       |       |       |finish |
 *
 * Above is a 3 x 7 grid. How many possible unique paths are there?
 *
 * Note: m and n will be at most 100.
 *
 * Strategy: dynamic programming.
 *
 * use an array of array to remember the unique paths of each position from start.
 * for position i, j. its unique ways is the sum of unique ways of its above and its left positions
 * sum[i][j] = sum[i-1][j] + sum[i][j-1]
 *
 *
 * | 1  | 1  |  1 | 1  | 1  |  1  |  1  |
 * | 1  |2   |  3 | 4  | 5  |  6  |  7  |
 * | 1  | 3  |  6 | 10 | 15 |  21 |  28 |
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] sum = new int[m][n];
        // edge case. there is one unique way to go to start from start.
        sum[0][0] = 1;
        for(int i = 1; i < n; i++) {
            sum[0][i] = 1;
        }
        for(int i = 1; i< m; i++) {
            sum[i][0] = 1;
        }
        for(int i = 1; i< m; i++) {
            for(int j = 1; j< n; j++) {
                sum[i][j] = sum[i-1][j] + sum[i][j-1];
            }
        }
        return sum[m-1][n-1];
    }

}
