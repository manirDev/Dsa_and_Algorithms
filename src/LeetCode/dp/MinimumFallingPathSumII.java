package LeetCode.dp;

import java.util.Arrays;

public class MinimumFallingPathSumII {
    public static void main(String[] args) {
        int[][] grid = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int[][] memo = new int[grid.length][grid.length];
        for (int[] row : memo){
            Arrays.fill(row, -101);
        }
        int res = Integer.MAX_VALUE;
        for (int i=0; i<grid.length; i++){
            res = Math.min(res, minFallingPathSumHelper(grid, 0, i, memo));
        }
        System.out.println(res);
    }

    private static int minFallingPathSumHelper(int[][] grid, int row, int col, int[][] memo) {
        boolean rowInBounds = row == grid.length - 1;
        boolean colInBounds = col >= 0 && col < grid.length;
        if (!colInBounds){
            return 0;
        }
        if (memo[row][col] != -101){
            return memo[row][col];
        }
        if (rowInBounds){
            return grid[row][col];
        }
        int res = Integer.MAX_VALUE;
        for (int c=0; c<grid.length; c++){
            if (c != col){
                res = Math.min(res, grid[row][col] + minFallingPathSumHelper(grid, row + 1, c, memo));
            }
        }
        memo[row][col] = res;
        return memo[row][col];
    }
}
