package LeetCode.dp;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int target = 3;
        Map<String, Integer> memo = new HashMap<>();
        int res = targetSumHelper(nums, target, 0, 0, memo);
        System.out.println(res);
    }

    private static int targetSumHelper(int[] nums, int target, int idx, int sum, Map<String, Integer> memo) {
        if (idx == nums.length){
            if (sum == target){
                return 1;
            }
            return 0;
        }
        String idxSum = idx + "," + sum;
        if (memo.containsKey(idxSum)){
            return memo.get(idxSum);
        }
        int plus = targetSumHelper(nums, target, idx + 1, sum + nums[idx], memo);
        int minus = targetSumHelper(nums, target, idx + 1, sum - nums[idx], memo);
        int res = plus + minus;
        memo.put(idxSum, res);
        return memo.get(idxSum);
    }
}
