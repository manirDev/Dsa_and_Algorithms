package LeetcodeDaily.Week3_30_09_2024;

import java.util.HashMap;
import java.util.Map;

public class MinSubarray {
    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 2};
        int p = 6;
        int res = helper(nums, p);
        System.out.println(res);
    }
    private static int helper(int[] nums, int p){
        int sum = 0;
        for (int num : nums) {
            sum = (sum + num) % p;
        }

        if (sum == 0) {
            return 0;
        }

        int currSum = 0, res = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int right = 0; right < nums.length; right++) {
            currSum = (currSum + nums[right]) % p;
            int diffRemainder = (currSum - sum + p) % p;
            if (map.containsKey(diffRemainder)) {
                res = Math.min(res, right - map.get(diffRemainder));
            }
            map.put(currSum, right);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
