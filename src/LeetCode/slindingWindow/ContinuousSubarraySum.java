package LeetCode.slindingWindow;

public class ContinuousSubarraySum {
    public static void main(String[] args) {
        int[] nums = {1, 0, 4, 6, 0};
        int k = 6;
        boolean res = helper(nums, k);
        System.out.println(res);
    }
    private static boolean helper(int[] nums, int k){
        int sum = nums[0];
        for (int i=1; i<nums.length; i++){
            sum = sum + nums[i];
            if (sum % k == 0){
                return true;
            }
        }
        int left = 0, right = nums.length - 1;
        while (left < right){
            int rightSum = sum - nums[left];
            int midSum = sum - nums[left] - nums[right];
            if (rightSum % k == 0 || midSum % k == 0){
                return true;
            }
            sum = sum - nums[right] - nums[left];
            left++;
            right--;
        }
        return false;
    }
}
