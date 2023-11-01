package LeetCode.dp;

import java.util.Arrays;

public class PathSumsDivisibleByK {
    public static void main(String[] args) {
        int[][] grid = {
                {7,3,4,9},
                {2,3,6,2},
                {2,3,7,0},
            };
        int k = 1;
        int[][][] memo = new int[grid.length][grid[0].length][k];
        for (int[][] x : memo){
            for (int[] y : x){
                Arrays.fill(y, -1);
            }
        }
        int mod =  1000000007;
        int res = pathSumsDivisibleByKHelper(grid, 0, 0, 0, k, mod, memo);
        System.out.println(res % mod);
    }

    private static int pathSumsDivisibleByKHelper(int[][] grid, int row, int col, int sum, int k, int mod,  int[][][] memo) {
        boolean rowInBounds = row < grid.length;
        boolean colInBounds = col < grid[0].length;
        if (!rowInBounds || !colInBounds){
            return 0;
        }
        if (row == grid.length - 1 && col == grid[0].length - 1){
            if ((sum + grid[row][col]) % k == 0){
                return 1;
            }
            return 0;
        }
        if (memo[row][col][sum % k] != -1){
            return memo[row][col][sum % k];
        }
        int right = pathSumsDivisibleByKHelper(grid, row, col + 1, sum + grid[row][col], k, mod, memo) % mod;
        int down = pathSumsDivisibleByKHelper(grid, row + 1, col, sum + grid[row][col], k, mod, memo) % mod;
        memo[row][col][sum % k] = (right + down) % mod;
        return memo[row][col][sum % k];
    }
}
