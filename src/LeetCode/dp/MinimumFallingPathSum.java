package LeetCode.dp;

import javax.swing.plaf.metal.MetalTheme;
import java.lang.reflect.Array;
import java.util.Arrays;

public class MinimumFallingPathSum {
    public static void main(String[] args) {
        int[][] grid = {
                {2,1,3},
                {6,5,4},
                {7,8,9}
        };
        int[][] memo = new int[grid.length][grid.length];
        for (int[] row : memo){
            Arrays.fill(row, -1);
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
            return (int)Math.pow(10, 7);
        }
        if (memo[row][col] != -1){
            return memo[row][col];
        }
        if (rowInBounds){
            return grid[row][col];
        }
        int leftDiagonal = grid[row][col] +  minFallingPathSumHelper(grid, row + 1, col - 1, memo);
        int down = grid[row][col] + minFallingPathSumHelper(grid, row + 1, col, memo);
        int rightDiagonal = grid[row][col] + minFallingPathSumHelper(grid, row + 1, col + 1, memo);
        int res = Math.min(down, Math.min(leftDiagonal, rightDiagonal));
        memo[row][col] = res;
        return memo[row][col];
    }
}
