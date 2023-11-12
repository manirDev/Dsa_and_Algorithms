package LeetCode.dp;

public class NumberOfIncreasingPathsInAGrid {
    public static void main(String[] args) {
        int[][] grid = {
                {1,1},
                {3,4}
        };
        int[][] memo = new int[grid.length][grid[0].length];
        int res = 0;
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[i].length; j++){
                res +=  countPathsHelper(grid, i, j, memo);
            }
        }
        System.out.println(res);
    }

    private static int countPathsHelper(int[][] grid, int row, int col, int[][] memo) {
        boolean rowInBounds = row >= 0 && row < grid.length;
        boolean colInBounds = col >= 0 && col < grid[0].length;
        if (!rowInBounds || !colInBounds){
            return 0;
        }
        if (memo[row][col] != 0){
            return memo[row][col];
        }
        int count = 1;
        int currCell = grid[row][col];
        if (col + 1 < grid[0].length){
            if (currCell < grid[row][col + 1]){
                count = (count + countPathsHelper(grid, row, col + 1, memo)) % 1000000007;
            }
        }
        if (col - 1 >= 0){
            if (currCell < grid[row][col - 1]){
                count = (count + countPathsHelper(grid, row, col - 1, memo)) % 1000000007;
            }
        }
        if (row + 1 < grid.length){
            if (currCell < grid[row + 1][col]){
                count = (count + countPathsHelper(grid, row + 1, col, memo)) % 1000000007;
            }
        }
        if (row - 1 >= 0){
            if (currCell < grid[row - 1][col]){
                count = (count + countPathsHelper(grid, row - 1, col, memo)) % 1000000007;
            }
        }
        memo[row][col] = count % 1000000007;
        return memo[row][col];
    }
}
