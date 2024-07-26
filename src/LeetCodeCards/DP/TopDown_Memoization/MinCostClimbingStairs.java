package LeetCodeCards.DP.TopDown_Memoization;

import java.util.Arrays;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] cost = {10,15,20};
        int[] memo = new int[cost.length + 1];
        Arrays.fill(memo, -101);
        int res = Math.min(minCostClimbingHelper(cost, 0, memo), minCostClimbingHelper(cost, 1, memo));
        System.out.println(res);
    }

    private static int minCostClimbingHelper(int[] cost, int step, int[] memo) {
        if (step >= cost.length){
            return 0;
        }
        if (memo[step] != -101){
            return memo[step];
        }
        int res = cost[step] + Math.min(minCostClimbingHelper(cost, step + 1, memo),  minCostClimbingHelper(cost, step + 2, memo));
        memo[step] = res;
        return memo[step];
    }
}
