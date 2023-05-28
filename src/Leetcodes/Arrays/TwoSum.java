package Leetcodes.Arrays;

import java.util.Arrays;
import java.util.HashMap;

/**
 Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

 You may assume that each input would have exactly one solution, and you may not use the same element twice.

 You can return the answer in any order.
 * **/
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {

        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        while(i < nums.length){
            int diff = target - nums[i];
            if (map.containsKey(diff)){
                res[0] = map.get(diff);
                res[1] = i;
            }
            map.put(nums[i], i);
            i++;
        }

        return res;
    }
}
