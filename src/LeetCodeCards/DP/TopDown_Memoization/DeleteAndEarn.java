package LeetCodeCards.DP.TopDown_Memoization;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeleteAndEarn {
    public static void main(String[] args) {
        int[] nums = {2,2,3,3,3,4};
        int res = 0;
        for (int i=0; i<nums.length; i++) {
            int[] memo = new int[nums.length + 1];
            Arrays.fill(memo, -101);
            int temp = earnHelper(nums, i, nums[i], memo);
            res = Math.max(res, temp);
        }
        System.out.println(res);
    }

    private static int earnHelper(int[] nums, int step, int picked, int[] memo) {
        if (step >= nums.length){
            return 0;
        }
        if (memo[step] != -101){
            return memo[step];
        }
        int delete = 0;
        int notDelete = 0;
        if (nums[step] != picked + 1 && nums[step] != picked - 1){
            delete = nums[step] + earnHelper(nums, step + 1, picked, memo);
        }

        notDelete = earnHelper(nums, step + 1, picked, memo);
        int res = Math.max(delete, notDelete);
        memo[step] = res;
        return memo[step];
    }
}
