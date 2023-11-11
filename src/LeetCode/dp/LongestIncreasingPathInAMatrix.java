package LeetCode.dp;

public class LongestIncreasingPathInAMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {9,9,4},
                {6,6,8},
                {2,1,1}
        };

        int res = Integer.MIN_VALUE;
        int[][] memo = new int[matrix.length][matrix[0].length];
        for (int i=0; i< matrix.length; i++){
            for (int j=0; j< matrix[i].length; j++){
                res = Math.max(res, longestIncreasingPathHelper(matrix, i, j, memo));
            }
        }
        System.out.println(res);
    }

    private static int longestIncreasingPathHelper(int[][] matrix, int row, int col, int[][] memo) {
        boolean rowInBounds = row >=0 && row < matrix.length;
        boolean colInBounds = col >=0 && col < matrix[0].length;
        if (!rowInBounds || !colInBounds){
            return 0;
        }
        if (memo[row][col] != 0){
            return memo[row][col];
        }
        int right = 1;
        int left = 1;
        int down = 1;
        int up = 1;
        int currCell = matrix[row][col];
        if (col + 1 < matrix[0].length){
            if (currCell < matrix[row][col + 1]){
                right = 1 + longestIncreasingPathHelper(matrix, row, col + 1, memo);
            }
        }
        if (col - 1 >= 0){
            if (currCell < matrix[row][col - 1]){
                left = 1 + longestIncreasingPathHelper(matrix, row, col - 1, memo);
            }
        }
        if (row + 1 < matrix.length){
            if (currCell < matrix[row + 1][col]){
                down = 1 + longestIncreasingPathHelper(matrix, row + 1, col, memo);
            }
        }
        if (row - 1 >= 0){
            if (currCell < matrix[row - 1][col]){
                up = 1 + longestIncreasingPathHelper(matrix, row - 1, col, memo);
            }
        }
        int res = Math.max(Math.max(right, left), Math.max(down, up));
        memo[row][col]= res;
        return memo[row][col];
    }
}
