package src.main.java;

/**
 * Created by xiaoyazi on 1/9/15.
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 *
 * The Sudoku board could be partially filled, where empty cells are filled with
 * the character '.'.
 *
 * A partially filled sudoku which is valid.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int m = 9;
        char[] column = new char[m];
        // check each row
        for (int i = 0; i< m; i++) {
            if (!isValid(board[i])) return false;
        }
        // check each column
        for (int i = 0; i < m; i++) {
            for (int j = 0; j< m; j++) {
                column[j] = board[j][i];
            }
            if (!isValid(column)) return false;
        }
        // check sub squares
        for (int i = 0; i< m; i+=3) {
            for (int j = 0; j< m; j+=3) {
                // i, j as the index of the top-left element of each sub square
                for (int x = 0; x<3; x++) {
                    for (int y = 0; y < 3; y++) {
                        column[3 * x + y] = board[i+x][j+y];
                    }
                }
                if (!isValid(column)) return false;
            }
        }
        return true;
    }

    // use array to check if there is duplicate char
    private boolean isValid(char[] data) {
        assert data.length == 9;
        boolean[] bag = new boolean[9];
        int index = 0;
        for (char i : data) {
            if (i!='.') {
                // convert char to int as the array index
                index = (int)(i - '1');
                if (bag[index]) return false;
                bag[index] = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidSudoku validSudoku = new ValidSudoku();
        char[] test = {'1', '1', '3', '4', '5', '6', '7', '8', '9',};
        System.out.println(validSudoku.isValid(test));
    }
}
