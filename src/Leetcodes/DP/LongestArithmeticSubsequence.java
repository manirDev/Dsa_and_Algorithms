package Leetcodes.DP;

import java.util.HashMap;

public class LongestArithmeticSubsequence {
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        int[] nums = {3,6,9,12};
        //max = Math.max(max, helper(nums));
        System.out.println(helper(nums));

    }

    private static int helper(int[] nums){
        int len = nums.length;
        int max = Integer.MIN_VALUE;
        HashMap<Integer, Integer>[] table = new HashMap[len];
        for(int i = 0; i < len; i++) {
            table[i] = new HashMap<>();
            for(int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];
                table[i].put(diff, table[j].getOrDefault(diff, 1)+1);
                max = Math.max(max, table[i].get(diff));
            }
        }
        return max;

    }
}
