package LeetCodeCards.DP.TopDown_Memoization;

public class MinFallingPathSum {
    public static void main(String[] args) {
        int[][] grid = {{2,1,3},{6,5,4},{7,8,9}};
        int[][] memo = new int[grid.length][grid.length];
        int res = Integer.MAX_VALUE;
        for (int i=0; i<grid.length; i++){
            res =  Math.min(res, helper(grid, 0, i, memo));
        }
        System.out.println(res);
    }
    private static int helper(int[][] grid, int row, int col, int[][] memo){
        boolean rowInBounds = row < grid.length;
        boolean colInBounds = col >= 0 && col < grid[row].length;
        if (!rowInBounds || !colInBounds){
            return Integer.MAX_VALUE;
        }
        if (row == grid.length - 1){
            return grid[row][col];
        }
        if (memo[row][col] != 0){
            return memo[row][col];
        }
        int down = helper(grid, row + 1, col, memo);
        int rightDown = helper(grid, row + 1, col + 1, memo);
        int leftDown = helper(grid, row + 1, col - 1, memo);
        int res = grid[row][col] + Math.min(down, Math.min(leftDown,  rightDown));
        memo[row][col] = res;
        return memo[row][col];
    }
}
