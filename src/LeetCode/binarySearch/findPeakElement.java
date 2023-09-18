package LeetCode.binarySearch;

public class findPeakElement {
    public static void main(String[] args) {
        int[] nums = {1,2,1,3,5,6,4};
        System.out.println(helper(nums));
    }

    private static int helper(int[] nums) {
        if(nums.length == 1) return 0;
        if (nums[0] > nums[1]){
            return 0;
        }
        //are bound elements peak ?
        if (nums[nums.length-1] > nums[nums.length-2]){
            return nums.length - 1;
        }
        int start = 1;
        int end = nums.length-2;

        while (start <= end){
            int mid = start + (end - start)/2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]){
                return mid;
            }
            else if (nums[mid] < nums[mid - 1]){
                end = mid - 1;
            }
            else if (nums[mid] < nums[mid + 1]){
                start = mid + 1;
            }
        }

        return -1;
    }
}
