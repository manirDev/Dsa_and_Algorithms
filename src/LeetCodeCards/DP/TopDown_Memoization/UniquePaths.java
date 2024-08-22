package LeetCodeCards.DP.TopDown_Memoization;

public class UniquePaths {
    public static void main(String[] args) {
        int m = 3, n = 7;
        int[][] memo = new int[m + 1][n + 1];
        int res = uniquePathHelper(0, 0, m, n, memo);
        System.out.println(res);
    }

    private static int uniquePathHelper(int row, int col, int m, int n, int[][] memo) {
        if(row == m - 1 || col == n - 1){
            return 1;
        }
        if (memo[row][col] != 0){
            return memo[row][col];
        }
        int res = uniquePathHelper(row + 1, col, m, n, memo) + uniquePathHelper(row, col + 1, m, n, memo);
        memo[row][col] = res;
        return memo[row][col];
    }
}
