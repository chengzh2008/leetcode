package src.main.java;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * <p>
 * click to show follow up.
 * <p>
 * Follow up:
 * Did you use extra space?
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 *
 *
 * Strategy: It is easy to think about that use two maps to record which row and which col
 * need to be set zeroes.
 *
 * But actually you can use one row and one col of the matrix as places to store the info for
 * resetting the values.
 *
 */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean firstRowZero = false;
        boolean firstColZero = false;


        // check if the first col need to be reset to zero
        for (int i = 0; i< m; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
            }
        }

        // check if the first row need to be reset to zero
        for (int j = 0; j< n; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
            }
        }

        // mark row and col that need to be reset on the first row and first col
        for (int i = 1; i< m; i++) {
            for (int j = 1; j< n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // mark all rows
        for (int i = 1; i< m; i++) {
            for (int j = 1; j< n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }


        // set the first row
        if (firstRowZero) {
            for(int j = 0; j< n; j++) {
                matrix[0][j] = 0;
            }
        }

        // set the first col
        if (firstColZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

    }
}
