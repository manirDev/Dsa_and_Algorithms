package LeetCode.slindingWindow;

public class BinarySubArraysWithSum {
    public static void main(String[] args) {
        int[] nums = {1,0,1,0,1};
        int goal = 2;

        int res = helper(nums, goal);
        System.out.println(res);
    }
    private static int helper(int[] nums, int goal){
        int res = 0;
        int right = 0, left = 0;
        int windowSum = 0;
        while (right < nums.length){
            windowSum = windowSum + nums[right];
            if (windowSum == goal){
                res = res + 1;
                windowSum = windowSum - nums[left];
                left = left + 1;
            }
            right = right + 1;
        }

        return res;
    }
}
