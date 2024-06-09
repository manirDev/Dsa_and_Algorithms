package LeetCode.prefixSum;

import java.util.HashMap;
import java.util.Map;

public class CheckSubarraySum {
    public static void main(String[] args) {
        int[] nums = {1, 2, 0, 0, 0};
        int k = 6;
        boolean res = checkSubarraySumHelper(nums, k);
        System.out.println(res);
    }

    private static boolean checkSubarraySumHelper(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(sum % k, -1);
        for (int i=0; i<nums.length; i++){
            sum = sum + nums[i];
            int remainder = sum % k;
            if (map.containsKey(remainder)){
                if (i - map.get(remainder) > 1){
                    return true;
                }
            }
            else{
                map.put(remainder, i);
            }
        }
        return false;
    }
}
