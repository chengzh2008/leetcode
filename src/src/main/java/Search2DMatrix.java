package src.main.java;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * For example,
 * <p>
 * Consider the following matrix:
 * <p>
 * [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 */
public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int startRow = 0;
        int endRow = m-1;
        int targetRow = -1;
        // divide and conquer to find the target row
        while(startRow <= endRow) {
            int middleRow = (startRow + endRow)/2;
            if (matrix[middleRow][0] > target) {
                endRow = middleRow-1;
            } else if (target > matrix[middleRow][n-1]) {
                startRow = middleRow+1;
            } else {
                targetRow = middleRow;
                break;
            }
        }
        if (startRow > endRow) {
            return false;
        }
        int startCol = 0;
        int endCol = n-1;
        // divide and conquer to find the target col
        while(startCol <= endCol) {
            int middleCol = (startCol + endCol)/2;
            if (matrix[targetRow][middleCol] < target) {
                startCol = middleCol+1;
            } else if (matrix[targetRow][middleCol] > target) {
                endCol = middleCol -1;
            } else {
                return true;
            }
        }
        return false;
    }
}
