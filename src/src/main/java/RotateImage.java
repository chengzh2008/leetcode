package src.main.java;

/**
 * You are given an n x n 2D matrix representing an image.
 * <p>
 * Rotate the image by 90 degrees (clockwise).
 * <p>
 * Follow up:
 * Could you do this in-place?
 * <p>
 * <p>
 * Strategy: do not think it in a traddionaly way.
 * <p>
 * [1, 2]    [4, 2]    [3, 1]
 * -->       -->
 * [3, 4]    [3, 1]    [4, 2]
 * <p>
 * swap elements symmetrically through back cross, then swap elements symmetrically in vertical.
 */
public class RotateImage {
    // swap back cross and swap horizontally half.
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                swap(matrix, i, j, n - 1 - j, n - 1 - i);
            }
        }

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                swap(matrix, i, j, n - 1 - i, j);
            }
        }
    }

    public void swap(int[][] matrix, int i, int j, int a, int b) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[a][b];
        matrix[a][b] = temp;
    }
}
