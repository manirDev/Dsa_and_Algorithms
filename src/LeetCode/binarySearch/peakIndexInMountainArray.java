package LeetCode.binarySearch;

public class peakIndexInMountainArray {
    public static void main(String[] args) {
        int[] nums = {0, 10, 3, 1, 2, 0};
        System.out.println(helper(nums));
    }
    private static int helper(int[] nums){
        int start = 0;
        int end = nums.length - 1;
        while (start < end){
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]){
                return mid;
            }
            if (nums[mid] > nums[mid - 1]){
                start = mid + 1;
            }
            else{
                end = mid;
            }
        }

        return start;
    }
}
