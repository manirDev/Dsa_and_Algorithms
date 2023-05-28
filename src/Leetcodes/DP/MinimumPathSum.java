package Leetcodes.DP;

public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int row = grid.length;
        int col = grid[0].length;
        int[][] memo = new int[row][col];
        System.out.println(minPathSum(memo, grid, 0, 0));
    }

    private static int minPathSum(int[][] memo, int[][] grid, int r, int c){
        if (r>= grid.length || c>=grid[0].length){
            return Integer.MAX_VALUE;
        }
        if (r == grid.length-1 && c == grid[0].length-1){
            return grid[r][c];
        }
        if (memo[r][c] != 0){
            return memo[r][c];
        }
        int result = grid[r][c] + Math.min(minPathSum(memo, grid, r+1, c), minPathSum(memo, grid, r, c+1));
        memo[r][c] = result;
        return memo[r][c];
    }
}
