package src.main.java;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to
 * bottom right which minimizes the sum of all numbers along its path.
 * <p>
 * Note: You can only move either down or right at any point in time.
 *
 * Strategy: dynamic programming
 *
 * formula: min[i][j] = Math.min(min[i-1][j]+ grid[i][j], min[i][j-1] + grid[i][j])
 *
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] min = new int[m][n];
        min[0][0] = grid[0][0];
        for (int i = 1; i< n; i++) {
            min[0][i] = min[0][i-1] + grid[0][i]; // fill the first row
        }
        for(int i = 1; i < m; i++ ) {
            min[i][0] = min[i-1][0] + grid[i][0]; // fill the first col
        }
        // fill the rest
        for(int i = 1; i< m; i++) {
            for(int j = 1; j<n; j++) {
                min[i][j] = Math.min(min[i-1][j]+ grid[i][j], min[i][j-1] + grid[i][j]);
            }
        }
        return min[m-1][n-1];
    }
}
