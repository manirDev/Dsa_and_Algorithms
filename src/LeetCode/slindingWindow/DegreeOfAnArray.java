package LeetCode.slindingWindow;

import java.util.HashMap;
import java.util.Map;

public class DegreeOfAnArray {
    public static void main(String[] args) {
        int[] nums = {1,2,2,3,1};
        int res = findShortestSubArrayHelper(nums);
        System.out.println(res);
    }

    private static int findMaxFreqHelper(int[] nums){
        Map<Integer, Integer> freq = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int i=0; i<nums.length; i++){
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
            max = Math.max(max, freq.get(nums[i]));
        }
        return max;
    }
    private static int findShortestSubArrayHelper(int[] nums) {
        Map<Integer, Integer> window = new HashMap<>();
        int maxFreq = findMaxFreqHelper(nums);
        int left = 0, right = 0;
        int res = Integer.MAX_VALUE;
        int subMaxFreq = Integer.MIN_VALUE;

        while (right < nums.length){
            window.put(nums[right], window.getOrDefault(nums[right], 0) + 1);
            subMaxFreq = Math.max(subMaxFreq, window.get(nums[right]));
            while (subMaxFreq == maxFreq){
                res = Math.min(res, right - left + 1);
                window.put(nums[left], window.get(nums[left]) - 1);
                if (subMaxFreq == window.get(nums[left]) + 1) {
                    subMaxFreq--;
                }
                left++;
            }

            right++;
        }
        return res;
    }

    private static void removeElementFromWindow(Map<Integer, Integer> window, int num) {
        Integer count = window.get(num);
        if (count != null && count > 1){
            window.put(num, count - 1);
        }else{
            window.remove(num);
        }
    }
}
