package LeetCode.dp;

import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) {
        int m = 3, n = 7;
        int[][] memo = new int[m + 1][n + 1];
        int res = uniquePathHelper(m, n, memo);
        System.out.println(res);
    }

    private static int uniquePathHelper(int r, int c, int[][] memo) {
        if (r == 1 || c == 1){
            return 1;
        }
        if (memo[r][c] != 0){
            return memo[r][c];
        }
        int right = uniquePathHelper(r, c - 1, memo);
        int down = uniquePathHelper(r - 1, c, memo);
        memo[r][c] = right + down;
        return memo[r][c];
    }
}
