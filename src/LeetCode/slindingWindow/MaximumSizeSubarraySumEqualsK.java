package LeetCode.slindingWindow;

public class MaximumSizeSubarraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = {-2,-1,2,1};
        int k = 1;
        int res = maxSubArraySumEqualsK(nums, k);
        System.out.println(res);
    }

    private static int maxSubArraySumEqualsK(int[] nums, int k) {
        int maxLen = 0;
        int windowSum = 0;
        int left = 0, right = 0;
        while (right < nums.length){
            windowSum = windowSum + nums[right];
            if (windowSum == k){
                maxLen = Math.max(maxLen, (right - left + 1));
                windowSum = windowSum - nums[left];
                left++;
            }
            right++;
        }
        return maxLen;
    }
}
