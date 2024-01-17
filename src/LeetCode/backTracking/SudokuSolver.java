package LeetCode.backTracking;

public class SudokuSolver {
    public static void main(String[] args) {
        char[][] board = {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
        };
        sudokuSolverHelper(board, 0, 0);
    }

    private static boolean sudokuSolverHelper(char[][] board, int row, int col) {
        if (row == board.length - 1 && col == board.length){
            return true;
        }
        if (col >= board.length){
            row = row + 1;
            col = 0;
        }
        if (board[row][col] != '.'){
            if(sudokuSolverHelper(board, row, col + 1)){
                return true;
            }
        }
        else {
            for (int value=1; value<=9; value++){
                if (isValidPlacement(board, row, col, value)){
                    board[row][col] = (char)(value + '0');
                    if(sudokuSolverHelper(board, row, col + 1)){
                        return true;
                    }
                    else{
                        board[row][col] = '.';
                    }
                }
            }
        }
        return false;
    }
    private static boolean isValidPlacement(char[][] board, int row, int col, int value){
        for (int r=0; r<board.length; r++){
            if (board[r][col] == (char)value){
                return false;
            }
        }
        for (int c=0; c<board.length; c++){
            if (board[row][c] == (char)value){
                return false;
            }
        }

        int rowIdx = row - (row % 3);
        int colIdx = col - (col % 3);
        for (int r=0; r<3; r++){
            for (int c=0; c<3; c++){
                if (board[r + rowIdx][c + colIdx] == (char)value){
                    return false;
                }
            }
        }

        return true;
    }
}
