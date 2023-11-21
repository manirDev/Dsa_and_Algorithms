package LeetCode.dp;

public class MaximalSquare {

    public static void main(String[] args) {
        char[][] grid = {
                    {'1', '0', '1', '0', '0'},
                    {'1', '0', '1', '1', '1'},
                    {'1', '1', '1', '1', '1'},
                    {'1', '0', '0', '1', '0'},
                };
        int[][] memo = new int[grid.length][grid[0].length];
        int res = 0;
        for (int i=0; i<grid.length; i++){
            for (int j = 0; j<grid[i].length; j++){
                res = Math.max(res, maximalSquareHelper(grid, i, j, memo));
            }
        }
        System.out.println(res * res);
    }

    private static int maximalSquareHelper(char[][] grid, int row, int col, int[][] memo) {
        boolean rowInBounds = row < grid.length;
        boolean colInBounds = col < grid[0].length;
        if (!rowInBounds || !colInBounds || grid[row][col] == '0'){
            return 0;
        }
        if (memo[row][col] != 0){
            return memo[row][col];
        }
        int right = maximalSquareHelper(grid, row, col + 1, memo);

        int down = maximalSquareHelper(grid, row + 1, col, memo);

        int diagonal = maximalSquareHelper(grid, row + 1, col + 1, memo);


        int res = 1 + Math.min(right, Math.min(down, diagonal));
        memo[row][col] = res;
        return memo[row][col];
    }
}
