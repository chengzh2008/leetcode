package src.main.java;

/**
 * Word Search Total Accepted: 34286 Total Submissions: 170511 My Submissions Question Solution
 * Given a 2D board and a word, find if the word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * <p>
 * For example,
 * Given board =
 * <p>
 * [
 * ["ABCE"],
 * ["SFCS"],
 * ["ADEE"]
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int wordSize = word.length();
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i< row; i++) {
            for (int j = 0; j < col; j++) {
                visited[i][j] = true; // remember reset the visited
                if(helper(board, i, j, 0, word, visited)) return true;
                visited[i][j] = false;
            }
        }
        return false;
    }

    public boolean helper(char[][] board, int i, int j, int start, String word, boolean[][] visited) {
        if (board[i][j] == word.charAt(start)) {
            if (start == word.length()-1) {
                return true;
            } else {
                if (i-1 >=0 && !visited[i-1][j]) {
                    visited[i-1][j] = true;
                    if (helper(board, i-1, j, start+1, word, visited)) return true;
                    visited[i-1][j] = false;
                }
                if (i+1 < board.length && !visited[i+1][j]) {
                    visited[i+1][j] = true;
                    if (helper(board, i+1, j, start+1, word, visited)) return true;
                    visited[i+1][j] = false;
                }
                if (j-1 >=0 && !visited[i][j-1]) {
                    visited[i][j-1] = true;
                    if (helper(board, i, j-1, start+1, word, visited)) return true;
                    visited[i][j-1] = false;
                }
                if (j+1 <board[0].length && !visited[i][j+1]) {
                    visited[i][j+1] = true;
                    if (helper(board, i, j+1, start+1, word, visited)) return true;
                    visited[i][j+1] = false;
                }
            }
        }
        return false;

    }
}
