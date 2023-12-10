package LeetCode.slindingWindow;

public class MaximumAverageSubarrayII {
    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
        double res = findMaxAverageHelper(nums, k);
        System.out.println(res);
    }

    private static double findMaxAverageHelper(int[] nums, int k) {
        double windowSum = 0.0;
        double sum = 0.0;
        for (int i=0; i<k; i++){
            windowSum += nums[i];
        }
        for (int i=0; i<nums.length; i++){
            sum += nums[i];
        }
        double windowAvg = windowSum / k;
        double avg = sum / nums.length;
        double maxAvg = Math.max(windowAvg, avg);
        for (int left=0, right = k; right<nums.length; right++){
            sum = sum + nums[right] - nums[left];
            avg = sum / (right - left + 1);
            windowSum = windowSum - nums[left] + nums[right];
            windowAvg = windowSum / k;
            maxAvg = Math.max(maxAvg, Math.max(avg, windowAvg));
            left++;
        }
        return maxAvg;
    }
}
