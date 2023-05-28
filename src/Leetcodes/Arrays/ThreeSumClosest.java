package Leetcodes.Arrays;


import java.util.Arrays;

/**
 Given an integer array nums of length n and an integer target, find three integers in nums such that
 the sum is closest to target.
 Return the sum of the three integers.
 You may assume that each input would have exactly one solution.
 **/
public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }

    public static int threeSumClosest(int[] nums, int target){
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i=0; i<nums.length; i++){
            int j = i+1;
            int k = nums.length - 1;
            while (j<k){
                int sum = nums[i]+nums[j]+nums[k];
                int diff = Math.abs(target - sum);
                if (diff < min){
                    min = diff;
                    res = sum;
                }
                else if (sum > target){
                    k--;
                }
                else if (sum < target){
                    j++;
                } else break;
            }
        }
        return res;
    }
}
