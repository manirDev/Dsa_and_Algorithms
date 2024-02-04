package LeetCode.heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        int[] res = topKFrequentHelper(nums, k);
        System.out.println(Arrays.toString(res));
    }

    private static int[] topKFrequentHelper(int[] nums, int k) {
        int[] res = new int[k];
        PriorityQueue<Integer> minHeap;
        Map<Integer, Integer> freq = new HashMap<>();

        for (int i=0; i<nums.length; i++){
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        minHeap = new PriorityQueue<>(
                (freq1, freq2) -> freq.get(freq1) - freq.get(freq2)
        );
        for (int key : freq.keySet()){
            minHeap.add(key);
            if (minHeap.size() > k){
                minHeap.poll();
            }
        }
        for (int i=0; i<k; i++){
            res[i] = minHeap.poll();
        }
        return res;
    }
}
