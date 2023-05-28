package Leetcodes.DP;

import java.util.Arrays;

public class MaximalSquare {
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) {

        char[][] matrix = {
                            {'1','0','1','0','0'},
                            {'1','0','1','1','1'},
                            {'1','1','1','1','1'},
                            {'1','0','0','1','0'}
                         };
        int[][] memo = new int[matrix.length][matrix[0].length];
        for (int[] arr:memo) {
            Arrays.fill(arr, -1);
        }
        helper(memo, matrix, 0, 0);
        System.out.println(max*max);
    }

    private static int helper(int[][] memo, char[][] grid, int r, int c){
        if (r>=grid.length || c>= grid[0].length){
            return 0;
        }
        int right = helper(memo, grid, r+1, c);
        int down = helper(memo, grid, r, c+1);
        int diagonal = helper(memo, grid, r+1, c+1);
        if (memo[r][c]!=-1){
            return memo[r][c];
        }

        if (grid[r][c]=='1'){
            int result = 1 + Math.min(right, Math.min(down, diagonal));
            max = Math.max(max, result);
            memo[r][c] = result;
            return memo[r][c];
        }
        return memo[r][c] = 0;
    }
}
