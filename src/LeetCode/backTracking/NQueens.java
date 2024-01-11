package LeetCode.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        List<List<String>> res =  solveNQueensHelper(n);
        for (List<String> row : res){
            System.out.println(row.toString());
        }

    }

    private static List<List<String>> solveNQueensHelper(int n) {
        char[][] board = new char[n][n];
        for (char[] row : board){
            Arrays.fill(row, '.');
        }
        List<List<String>> res = new ArrayList<>();
        playHelper(board, 0, res);
        return res;
    }

    private static void playHelper(char[][] board, int row, List<List<String>> res) {
        if (row >= board.length){
            res.add(new ArrayList<>(constructedPattern(board)));
        }
        for (int col = 0; col < board.length; col++){
            if (isValidCell(board, row, col)){
                board[row][col] = 'Q';
                playHelper(board, row + 1, res);
                board[row][col] = '.';
            }
        }
    }

    private static boolean isValidCell(char[][] board, int row, int col) {
        for (int r=0; r <row; r++){
            if (board[r][col] == 'Q'){
                return false;
            }
        }
        for (int r=row - 1, c=col - 1; r>=0&&c>=0; r--, c--){
            if (board[r][c] == 'Q'){
                return false;
            }
        }
        for (int r=row - 1, c=col + 1; r>=0&&c< board.length; r--, c++){
            if (board[r][c] == 'Q'){
                return false;
            }
        }
        return true;
    }

    private static List<String> constructedPattern(char[][] board) {
        List<String> pattern = new ArrayList<>();
        for (char[] row : board){
            pattern.add(new String(row));
        }
        return pattern;
    }
}
