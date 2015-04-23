package src.main.java;

import java.util.Stack;

/**
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

 A region is captured by flipping all 'O's into 'X's in that surrounded region.

 For example,
 X X X X
 X O O X
 X X O X
 X O X X
 After running your function, the board should be:

 X X X X
 X X X X
 X X X X
 X O X X


 Strategy: start working from the sides, change all 'O's not surrounded by 'X' to 'Y'.
 then, change all 'O' to 'X', later chage 'Y' back to 'O'.
 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        if (board.length < 3 || board[0].length < 3) return;
        fillBorder(board, 'O', 'Y');
        replace(board, 'O', 'X');
        fillBorder(board, 'Y', 'O');
    }

    public void fillBorder(char[][] board, char target, char newChar) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i< m; i++) {
            if(board[i][0] == target) fill(board, i, 0, target, newChar);
            if(board[i][n-1] == target) fill(board, i, n-1, target, newChar);
        }

        for (int i = 0; i< n; i++) {
            if(board[0][i] == target) fill(board, 0, i,  target, newChar);
            if(board[m-1][i] == target) fill(board, m-1, i, target, newChar);
        }
    }

    public void fill(char[][] board, int i, int j, char target, char newChar) {
        int m = board.length;
        int n = board[0].length;
        Stack<Integer> iStack = new Stack<>();
        Stack<Integer> jStack = new Stack<>();
        iStack.push(i);
        jStack.push(j);
        while(!iStack.isEmpty()){
            i = iStack.pop();
            j = jStack.pop();
            board[i][j] = newChar;
            if(i > 0 && board[i-1][j] == target) {
                iStack.push(i-1);
                jStack.push(j);
            }
            if(i < m-1 && board[i+1][j] == target) {
                iStack.push(i+1);
                jStack.push(j);
            }
            if(j > 0 && board[i][j-1] == target) {
                iStack.push(i);
                jStack.push(j-1);
            }
            if(j < n-1 && board[i][j+1] == target) {
                iStack.push(i);
                jStack.push(j+1);
            }
        }
    }

    public void replace(char[][] board, char target, char newChar) {
        for(int i = 0; i< board.length; i++) {
            for(int j = 0; j<board[0].length;j++) {
                if (board[i][j] == target) {
                    board[i][j] = newChar;
                }
            }
        }
    }
}
