package LeetCode.dp;

import java.util.Arrays;

public class NumberOfDiceRollsWithTargetSum {
    static int MOD = 1000000007;
    public static void main(String[] args) {
        int n = 2, k = 6, target = 7;
        int[][] memo = new int[n + 1][target + 1];
        for (int[] row : memo){
            Arrays.fill(row, -1);
        }
        int res = diceRollsHelper(n, k, target, memo);
        System.out.println(res);
    }

    private static int diceRollsHelper(int n, int k, int target, int[][] memo) {
        if (n < 0 || target < 0){
            return 0;
        }
        if (n == 0 && target == 0){
            return 1;
        }
        if (memo[n][target] != -1){
            return memo[n][target];
        }
        int res = 0;
        for (int faceVal=1; faceVal<=k; faceVal++){
            res = (res + diceRollsHelper(n - 1, k, target - faceVal, memo)) % MOD;
        }
        memo[n][target] = res;
        return memo[n][target];
    }
}
