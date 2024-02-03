package LeetCode.heap;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    static int reSize = 0;
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        int res = findKthLargestHelper(nums, k);
        System.out.println(res);
        System.out.println(helper(nums, k));
    }

    private static int helper(int[] nums, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i=0; i<nums.length; i++){
            minHeap.add(nums[i]);
            if (minHeap.size() > k){
                minHeap.poll();
            }
        }
        return  minHeap.peek();
    }
    private static int findKthLargestHelper(int[] nums, int k) {
        int[] arr = new int[nums.length + 1];
        for (int i=0; i<nums.length; i++){
            add(arr, nums[i]);
        }
        int res = 0;
        while (k > 0){
            res = pop(arr);
            k--;
        }
        return res;
    }
    private static void add(int[] nums, int element){
        reSize++;
        if (reSize > nums.length){
            return;
        }
        nums[reSize] = element;
        int idx = reSize;
        int parent = idx / 2;
        while (nums[idx] > nums[parent] && idx > 1){
            int temp = nums[idx];
            nums[idx] = nums[parent];
            nums[parent] = temp;
            idx = parent;
            parent = idx / 2;
        }
    }
    private static int pop(int[] nums){
        if (reSize < 1){
            return 0;
        }
        int toBeRemoved = nums[1];
        nums[1] = nums[reSize];
        reSize--;
        int idx = 1;
        while (idx <= reSize / 2){
            int left = (idx * 2);
            int right = (idx * 2);
            if (nums[idx] < nums[left] || nums[idx] < nums[right]){
                if (nums[idx] < nums[left]){
                    int temp = nums[idx];
                    nums[idx] = nums[left];
                    nums[left] = temp;
                    idx = left;
                }
                else{
                    int temp = nums[idx];
                        nums[idx] = nums[right];
                    nums[right] = temp;
                    idx = right;
                }
            }
            else{
                break;
            }
        }
        return toBeRemoved;
    }
}
