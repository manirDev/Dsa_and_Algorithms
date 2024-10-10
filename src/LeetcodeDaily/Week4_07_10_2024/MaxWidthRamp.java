package LeetcodeDaily.Week4_07_10_2024;

public class MaxWidthRamp {
    public static void main(String[] args) {
        int[] nums = {7,8,1,0,1,7,4,6,6,1};
        int res = helper(nums);
        System.out.println(res);
    }
    private static int helper(int[] nums){
        int res = 0;
        int n = nums.length;
        int[] arr = new int[n];
        int max = nums[n-1];
        for (int i=n-1; i>=0; i--){
            max = Math.max(max, nums[i]);
            arr[i] = max;
        }
        int left = 0, right = left + 1;
        while (right < n){
            if (nums[left] <= arr[right]){
                res = Math.max(res, (right - left));
                right++;
            }
            else {
                left++;
            }
        }
        return res;
    }
}
