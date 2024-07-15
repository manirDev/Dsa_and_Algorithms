package LeetCode.prefixSum;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = {1,2,3, -6, 6};
        int k = 6;
        int res = subarraySumHelper(nums, k);
        System.out.println(res);
    }

    private static int subarraySumHelper(int[] nums, int k) {
        int res = 0;
        Map<Integer, Integer> sums = new HashMap<>();
        sums.put(0, 1);
        int pSum = 0;
        for (int num : nums){
            pSum = pSum + num;
            int diff = pSum - k;
            if (sums.containsKey(diff)){
                res = res + sums.get(diff);
            }
            sums.put(pSum, sums.getOrDefault(pSum, 0) + 1);
        }
        return res;
    }
}
