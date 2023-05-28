package Leetcodes.DP;

public class TargetSum {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int target = 3;
        System.out.println(helper(nums, target, 0, 0));
    }

    private static int helper(int[] nums, int target, int i, int sum){
        if (i==nums.length){
            if (sum == target){
                return 1;
            }else{
                return 0;
            }
        }

        int count = 0;
        count +=helper(nums, target, i+1, sum+nums[i]);
        count +=helper(nums, target, i+1, sum-nums[i]);

        return count;
    }
}
