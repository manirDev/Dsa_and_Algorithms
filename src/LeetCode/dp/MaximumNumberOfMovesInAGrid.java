package LeetCode.dp;

import java.util.Arrays;

public class MaximumNumberOfMovesInAGrid {
    public static void main(String[] args) {
        int[][] grid = {
                        {3,2,4},
                        {2,1,9},
                        {1,1,7},
                    };
        int res = 0;
        for (int i=0; i< grid.length; i++){
            int[][] memo = new int[grid.length][grid[0].length];
            for (int[] row : memo){
                Arrays.fill(row, -1);
            }
            res = Math.max(res, movesHelper(grid, i, 0, memo));
        }
        System.out.println(res);
    }

    private static int movesHelper(int[][] grid, int row, int col, int[][] memo) {
        boolean rowInBounds = row >= 0 && row < grid.length;
        boolean colInBounds = col >= 0 && col < grid[0].length;
        if (!rowInBounds || !colInBounds){
            return 0;
        }
        if (memo[row][col] != -1){
            return memo[row][col];
        }
        int currCel = grid[row][col];
        int upRight = 0;
        int downRight = 0;
        int right = 0;
        if (row - 1 >= 0 && col + 1 < grid[0].length){
            if (currCel < grid[row - 1][col + 1]){
                upRight = 1 + movesHelper(grid, row - 1, col + 1, memo);
            }
        }
        if (col + 1 < grid[0].length){
            if (currCel < grid[row][col + 1]){
                right = 1 + movesHelper(grid, row, col + 1, memo);
            }
        }
        if (row + 1 < grid.length && col + 1 < grid[0].length){
            if (currCel < grid[row + 1][col + 1]){
                downRight = 1 + movesHelper(grid, row + 1, col + 1, memo);
            }
        }
        memo[row][col] = Math.max(upRight, Math.max(right, downRight));
        return memo[row][col];
    }
}
