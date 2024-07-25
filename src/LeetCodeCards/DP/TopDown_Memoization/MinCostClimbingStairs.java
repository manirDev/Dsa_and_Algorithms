package LeetCodeCards.DP.TopDown_Memoization;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] cost = {10,15,20};
        int res = minCostClimbingHelper(cost, cost.length-1);
        System.out.println(res);
    }

    private static int minCostClimbingHelper(int[] cost, int step) {
        if (step == 0){
            return cost[step];
        }
        if (step == 1){
            return cost[step];
        }
        if (step < 0){
            return 0;
        }
        int oneStep = cost[step] + minCostClimbingHelper(cost, step - 1);
        int twoStep = cost[step] + minCostClimbingHelper(cost, step - 2);
        return Math.min(oneStep, twoStep);
    }
}
