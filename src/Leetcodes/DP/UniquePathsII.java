package Leetcodes.DP;

public class UniquePathsII {
    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        int row = obstacleGrid.length - 1;
        int col = obstacleGrid[0].length - 1;
        int[][] memo = new int[row+1][col+1];
        System.out.println(uniquePathsWithObstacles(memo, obstacleGrid, row, col));
    }

    private static int uniquePathsWithObstacles(int[][] memo,  int[][] grid, int r, int c){
        if (r<0 || c<0 || grid[r][c]==1){
            return 0;
        }

        if (r==0 && c==0){
            return 1;
        }
        if(memo[r][c] != 0){
            return memo[r][c];
        }
        else{
            int down = uniquePathsWithObstacles(memo, grid, r-1, c);
            int right = uniquePathsWithObstacles(memo, grid, r, c-1);
            memo[r][c] = down + right;
            return memo[r][c];
        }
    }
}
