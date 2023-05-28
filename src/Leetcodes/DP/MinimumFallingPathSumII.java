package Leetcodes.DP;

import java.util.Arrays;

public class MinimumFallingPathSumII {
    public static void main(String[] args) {
        int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};
        int result = Integer.MAX_VALUE;
        int m = grid.length;
        int n = grid[0].length;
        int[][] memo = new int[m][n];
        for (int[] arr :memo) {
            Arrays.fill(arr, -100);
        }
        for (int i=0; i< grid.length; i++){
            result = Math.min(result, helper(memo, grid, 0, i));
        }
        System.out.println(result);
    }
    private static int helper(int[][] memo, int[][] grid, int r, int c){
        if (c < 0 || c > grid.length-1){
            return 0;
        }
        if (r== grid.length-1){
            return grid[r][c];
        }
        if (memo[r][c]!=-100){
            return memo[r][c];
        }
        int result = Integer.MAX_VALUE;
        for (int j=0; j<grid.length; j++){
            if (j==c){
                continue;
            }
            result = Math.min(result, grid[r][c]+helper(memo, grid, r+1, j));
        }
        memo[r][c] = result;
        return memo[r][c];
    }

}
