package LeetCodeCards.DP.TopDown_Memoization;

import java.util.Arrays;

public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int[] memo = new int[nums.length + 1];
        Arrays.fill(memo,  -101);
        int res = houseRobberHelper(nums, 0, memo);
        System.out.println(res);
    }

    private static int houseRobberHelper(int[] nums, int step, int[] memo) {
        if (step >= nums.length){
            return 0;
        }
        if (memo[step] != 0){
            return memo[step];
        }
        int robbed = nums[step] + houseRobberHelper(nums, step + 2, memo);
        int notRobbed = houseRobberHelper(nums, step + 1, memo);
        memo[step] = Math.max(robbed, notRobbed);
        return memo[step];
    }
}
