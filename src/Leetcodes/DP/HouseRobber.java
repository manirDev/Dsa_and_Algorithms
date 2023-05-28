package Leetcodes.DP;

import java.util.Arrays;

public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        System.out.println(rob(memo, nums, 0));
    }
    private static int rob(int[] memo, int[] nums, int x){
        if (x >= nums.length){
            return 0;
        }
        if (memo[x] != -1){
            return memo[x];
        }
        int result = Math.max(nums[x] + rob(memo, nums, x+2), rob(memo, nums, x+1));
        memo[x] = result;
        return memo[x];
    }
}
