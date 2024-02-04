package LeetCode.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MinimumCostToConnectSticks {
    public static void main(String[] args) {
        int[] nums = {2, 4, 3};
        int res = connectSticksHelper(nums);
        System.out.println(res);
    }

    private static int connectSticksHelper(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int res = 0;
        for (int num : nums) {
            minHeap.add(num);
        }
        while (!minHeap.isEmpty()) {
            if (minHeap.size() == 1) {
                return res;
            }
            int s1 = minHeap.poll();
            int s2 = minHeap.poll();
            res = res + (s1 + s2);
            minHeap.add(s1 + s2);
        }
        return 0;
    }
}
