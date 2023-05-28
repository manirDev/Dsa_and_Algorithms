package Leetcodes.DP;

import java.util.Arrays;

public class PathWithMaximumGold {
    public static void main(String[] args) {
        int[][] grid = {
                        {0,6,0},
                        {5,8,7},
                        {0,9,0}
                       };

        int row = grid.length;
        int col = grid[0].length;
        int[][] memo = new int[row][col];
        for(int[] arr: memo){
            Arrays.fill(arr, -1);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i<row; i++){
            for (int j=0; j<col; j++){
                max = Math.max(max, getMaximumGold(memo, grid, i, j));
            }
        }
        System.out.println(max);
    }

    //left, right, up, or down.
    private static int getMaximumGold(int[][] memo, int[][] grid, int r, int c){
        if(r>= grid.length || c>= grid.length || r<0 || c<0){
            return 0;
        }
        if (grid[r][c]==0){
            return 0;
        }
        if (memo[r][c]!=-1){
            return memo[r][c];
        }
        int temp = grid[r][c];
        //marking the position as visited
        grid[r][c] = 0;
        int left = getMaximumGold(memo, grid, r, c-1) + temp;
        int right = getMaximumGold(memo, grid, r, c+1) + temp;
        int down = getMaximumGold(memo, grid, r+1, c) + temp;
        int up = getMaximumGold(memo, grid, r-1, c) + temp;
        int result = Math.max(left, Math.max(right, Math.max(down, up)));
        memo[r][c] = result;
        grid[r][c] = temp;
        return result;
    }
}
