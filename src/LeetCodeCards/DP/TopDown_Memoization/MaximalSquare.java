package LeetCodeCards.DP.TopDown_Memoization;

import Libraries.Libs;

public class MaximalSquare {
    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        int res = Libs.min_int;
        int[][] memo = new int[matrix.length + 1][matrix.length + 1];
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[i].length; j++){
                res = Math.max(res, maxSquareHelper(matrix, i, j, memo));
            }
        }
        System.out.println(res * res);
    }

    private static int maxSquareHelper(char[][] matrix, int row, int col, int[][] memo) {
        if (Libs.isNotInLenBounds(row, col, matrix.length, matrix[0].length) || matrix[row][col] == '0'){
            return 0;
        }
        if (memo[row][col] != 0){
            return memo[row][col];
        }
        int right = maxSquareHelper(matrix, row, col + 1, memo);
        int down = maxSquareHelper(matrix, row + 1, col, memo);
        int diagonal = maxSquareHelper(matrix, row + 1, col + 1, memo);
        int res = 1 + Math.min(right, Math.min(down, diagonal));
        memo[row][col] = res;
        return memo[row][col];
    }

}
