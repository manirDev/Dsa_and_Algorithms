package LeetCode.binarySearch;

public class SingleElementInASortedArray {
    public static void main(String[] args) {
        int[] nums= {1,1,2,3,3,4,4,8,8};
        System.out.println(helper(nums));

    }
    private static int helper(int[] nums){
        int start = 0;
        int end = nums.length - 1;
        while (start < end){
            int mid = start + (end - start) / 2;
            if (mid % 2 == 1) {
                mid--;
            }
            if (nums[mid] != nums[mid + 1]) {
                end = mid;
            } else {
                start = mid + 2;
            }
        }
        return nums[start];
    }
}
