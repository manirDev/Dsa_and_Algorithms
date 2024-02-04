package LeetCode.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public static void main(String[] args) {
        int[] nums = {2,7,4,1,8,1};
        int res = lastStoneWeightHelper(nums);
        System.out.println(res);
    }

    private static int lastStoneWeightHelper(int[] nums) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums){
            maxHeap.add(num);
        }
        while (!maxHeap.isEmpty()){
            if (maxHeap.size() == 1){
                return maxHeap.peek();
            }
            int y = maxHeap.poll();
            int x = maxHeap.poll();
            if (x != y){
                maxHeap.add(y - x);
            }
        }
        return 0;
    }
}
