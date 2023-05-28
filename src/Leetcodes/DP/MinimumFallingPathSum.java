package Leetcodes.DP;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MinimumFallingPathSum {
    public static void main(String[] args) {
//        int[][] matrix = {  {2,1,3},
//                            {6,5,4},
//                            {7,8,9} };
        int[][] matrix = {{-19,57},{-40,-5}};
        int n = matrix.length;
        int[][] memo = new int[n][n];
        for (int[] m:memo) {
            Arrays.fill(m, -1);
        }
        int result = Integer.MAX_VALUE;
        for(int i=0; i<matrix.length; i++){
            result = Math.min(result, helper(memo, matrix, 0, i));
        }
        System.out.println(result);
    }

    /**
     (row, col) , (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).
     **/
    private static int helper(int[][] memo, int[][] grid, int r, int c){
        if (r>= grid.length || c>= grid.length){
            return 0;
        }
        if (r==grid.length-1){
            return grid[r][c];
        }
        if (memo[r][c] != -1){
            return memo[r][c];
        }
        int leftDiagonal = Integer.MAX_VALUE;
        int down = Integer.MAX_VALUE;
        int rightDiagonal = Integer.MAX_VALUE;
        if (r+1<grid.length && c-1>=0){
            leftDiagonal = helper(memo, grid, r+1, c-1);
        }
        if (r+1<grid.length){
            down = helper(memo, grid, r+1, c);
        }
        if (r+1<grid.length && c+1< grid.length){
            rightDiagonal = helper(memo, grid, r+1, c+1);
        }

        memo[r][c] = grid[r][c] + Math.min(down, Math.min(leftDiagonal, rightDiagonal));
        return memo[r][c];
    }
}
