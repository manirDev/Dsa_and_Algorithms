package LeetCode.slindingWindow;

public class MaximumAverageSubarrayI {
    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
        double res = findMaxAverageHelper(nums, k);
        System.out.println(res);
    }

    private static double findMaxAverageHelper(int[] nums, int k) {
        double windowSum = 0.0;
        double windowAvg = 0.0;
        for (int i=0; i<k; i++){
            windowSum += nums[i];
        }
        windowAvg = windowSum / k;
        double maxAvg = windowAvg;
        for (int left=0, right = k; right<nums.length; right++){
            windowSum = windowSum - nums[left] + nums[right];
            double tempAvg = windowSum / k;
            maxAvg = Math.max(maxAvg, tempAvg);
            left++;
        }
        return maxAvg;
    }
}
