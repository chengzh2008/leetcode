package src.main.java;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * <p>
 * Empty cells are indicated by the character '.'.
 * <p>
 * You may assume that there will be only one unique solution.
 * <p>
 * <p>
 * A sudoku puzzle...
 *   http://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Sudoku-by-L2G-20050714.svg/250px-Sudoku-by-L2G-20050714.svg.png

 * <p>
 * <p>
 * ...and its solution numbers marked in red.
 * http://upload.wikimedia.org/wikipedia/commons/thumb/3/31/Sudoku-by-L2G-20050714_solution.svg/250px-Sudoku-by-L2G-20050714_solution.svg.png
 */
public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) return;
        solve(board);
    }


    public boolean solve(char[][] board) {
        for(int i = 0; i< board.length; i++) {
            for (int j = 0; j< board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1';c <='9'; c++) {
                        if(isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if(solve(board)) return true;
                            else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int i, int j, char c) {
        for (int row = 0; row < 9; row++) {
            if(board[row][j] == c) return false;
        }
        for(int col = 0; col < 9; col++) {
            if(board[i][col] == c) return false;
        }
        for(int row = i/3 * 3; row < i/3 * 3 + 3; row++) {
            for (int col = j/3 * 3; col < j/3 * 3 + 3; col++) {
                if (board[row][col] == c) return false;
            }
        }
        return true;
    }

}
