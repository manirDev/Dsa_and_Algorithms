package LeetCode.dp;

import java.util.Arrays;

public class UniquePathsII {
    public static void main(String[] args) {
        int[][] grid = {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };
        if(grid[grid.length-1][grid[0].length-1]==1) {
            System.out.println(0);
        };
        int[][] memo = new int[grid.length+1][grid.length+1];
        for (int[] row : memo){
            Arrays.fill(row, -1);
        }
        int res = uniquePathsHelper(grid, 0, 0, memo);
        System.out.println(res);
    }

    private static int uniquePathsHelper(int[][] grid, int row, int col, int[][] memo) {
        boolean rowInBounds = row >=0 && row < grid.length;
        boolean colInBounds = col >= 0 && col < grid[0].length;
        if (!(rowInBounds && colInBounds) || grid[row][col] == 1){
            return 0;
        }
        if (row == grid.length - 1 && col == grid[0].length - 1){
            return 1;
        }
        if (memo[row][col] != -1){
            return memo[row][col];
        }
        memo[row][col] = uniquePathsHelper(grid, row, col + 1, memo) + uniquePathsHelper(grid, row + 1, col, memo);
        return memo[row][col];
    }
}
