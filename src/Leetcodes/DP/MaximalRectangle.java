package Leetcodes.DP;

public class MaximalRectangle {
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        helper(matrix, 0, 0, matrix.length);
        System.out.println(max);
    }
    private static int helper(char[][] grid, int r, int c, int m){
        if (r>=m || c>= m){
            return 0;
        }
        int right = helper(grid, r, c+1, m);
        int down = helper(grid, r+1, c, m);
        int diagonal = helper(grid, r+1, c+1, m);
        if (grid[r][c]=='1'){
            int result = 1 + Math.min(right, Math.min(down, diagonal));
            max = Math.max(max, result);
            return max;
        }
        return 0;
    }
}
