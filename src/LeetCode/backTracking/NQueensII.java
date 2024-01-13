package LeetCode.backTracking;

import java.util.Arrays;

public class NQueensII {
    static int count = 0;
    public static void main(String[] args) {
        int n = 1;
        int res = solveNQueensHelper(n);
        System.out.println(res);
    }
    private static int solveNQueensHelper(int n){
        char[][] board = new char[n][n];
        for (char[] row : board){
            Arrays.fill(row, '.');
        }
        playHelper(board, 0);
        return count;
    }
    private static void playHelper(char[][] board, int rowIdx){
        if (rowIdx >= board.length) {
            count = count  + 1;
        }
        for (int col=0; col<board.length; col++){
            if (isValidPlacement(board, rowIdx, col)){
                board[rowIdx][col] = 'Q';
                playHelper(board, rowIdx  + 1);
                board[rowIdx][col] = '.';
            }
        }
    }
    private static boolean isValidPlacement(char[][] board, int rowIdx, int colIdx){
        for (int row=0; row<rowIdx; row++){
            if (board[row][colIdx] == 'Q'){
                return false;
            }
        }
        for (int row=rowIdx-1, col=colIdx-1; row>=0 && col>=0; row--, col--){
            if (board[row][col] == 'Q'){
                return false;
            }
        }
        for (int row=rowIdx-1, col=colIdx+1; row>=0 && col<board.length; row--, col++){
            if (board[row][col] == 'Q'){
                return false;
            }
        }
        return true;
    }
}
