package LeetCode.slindingWindow;

import java.util.*;

public class DistinctNumbersInEachSubarray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,2,2,1,3};
        int k = 3;
        int[] res = distinctNumbersHelper(nums, k);
        System.out.println(Arrays.toString(res));
    }

    private static int[] distinctNumbersHelper(int[] nums, int k) {
        int[] res  = new int[nums.length - k + 1];
        Map<Integer, Integer> window = new HashMap<>();
        for (int i=0; i<k; i++){
            window.put(nums[i], window.getOrDefault(nums[i], 0) + 1);
        }
        res[0] = window.size();
        int right = k, left = 0, idx = 1;
        while (right < nums.length){
            removeFromWindow(window, nums[left]);
            window.put(nums[right], window.getOrDefault(nums[right], 0) + 1);
            res[idx] = window.size();
            idx++;
            left++;
            right++;
        }
        return res;
    }

    private static void removeFromWindow(Map<Integer, Integer> window, int num) {
        Integer count = window.get(num);
        if (count != null && count > 1){
            window.put(num, count - 1);
        }else{
            window.remove(num);
        }
    }
}
