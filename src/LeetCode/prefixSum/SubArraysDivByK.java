package LeetCode.prefixSum;

import java.util.HashMap;
import java.util.Map;

public class SubArraysDivByK {
    public static void main(String[] args) {
        int[] nums = {4,5,0,-2,-3,1};
        int k = 5;
        int res = subArraysDivByKHelper(nums, k);
        System.out.println(res);
    }

    private static int subArraysDivByKHelper(int[] nums, int k) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(sum % k, 1);
        for (int num : nums){
            sum = sum + num;
            int remainder = sum % k;
            if (remainder < 0){
                remainder = remainder + k;
            }
            if (map.containsKey(remainder)){
                res = res + map.get(remainder);
                map.put(remainder, map.get(remainder) + 1);
            }
            else{
                map.put(remainder, 1);
            }
        }
        return res;
    }
}
