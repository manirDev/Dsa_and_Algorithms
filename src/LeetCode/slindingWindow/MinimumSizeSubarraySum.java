package LeetCode.slindingWindow;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        int res = minSizeSubArraySumHelper(nums, target);
        System.out.println(res);
    }

    private static int minSizeSubArraySumHelper(int[] nums, int target) {
        if (nums.length == 0){
            return 0;
        }
        int minLen = nums.length + 1;
        int windowSum = 0;
        int left = 0, right = 0;
        while (right < nums.length){
            windowSum = windowSum + nums[right];
            while (windowSum >= target){
                minLen = Math.min(minLen, (right - left + 1));
                windowSum = windowSum - nums[left];
                left++;
            }
            right++;
        }
        return minLen;
    }
}
