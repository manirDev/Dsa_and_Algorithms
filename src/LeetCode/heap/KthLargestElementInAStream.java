package LeetCode.heap;

import java.util.List;
import java.util.PriorityQueue;

public class KthLargestElementInAStream {

    PriorityQueue<Integer> minHeap;
    int k;

    public KthLargestElementInAStream(int k, int[] nums){
        this.k = k;
        this.minHeap = new PriorityQueue<>();
        for (int num : nums){
            minHeap.add(num);
            if (minHeap.size() > k){
                minHeap.poll();
            }
        }
    }

    public int add(int val){
        minHeap.add(val);
        if (minHeap.size() > k){
            minHeap.poll();
        }
        return minHeap.peek();
    }
    public static void main(String[] args) {
        KthLargestElementInAStream kthLargest = new KthLargestElementInAStream(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }
}
