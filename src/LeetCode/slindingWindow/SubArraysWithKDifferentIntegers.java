package LeetCode.slindingWindow;

import java.util.HashMap;
import java.util.Map;

public class SubArraysWithKDifferentIntegers {
    public static void main(String[] args) {
         int[] nums = {1,2,1,3,4};
         int k = 3;
         int res = helper(nums, k) - helper(nums, k - 1);
        System.out.println(res);
    }
    private static int helper(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0, left = 0, right = 0;
        while (right < nums.length){
            map.put(nums[right], map.getOrDefault(nums[right], 0) +1);
            while (map.size() > k){
                removeHelper(nums[left], map);
                //res = res + 1;
                left++;
            }
            res = res + right - left + 1;
            right++;
        }
        return res;
    }

    private static void removeHelper(int num, Map<Integer, Integer> map) {
        Integer count = map.get(num);
        if (count != null && count > 1){
            map.put(num, count - 1);
        }else{
            map.remove(num);
        }
    }
}
