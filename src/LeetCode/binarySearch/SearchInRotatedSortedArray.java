package LeetCode.binarySearch;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        int pivot = findPivotElement(nums);
        System.out.println(pivot);
         if (nums[pivot] == target){
             System.out.println(pivot);
         }
         int left = binarySearch(nums,  target, 0, pivot - 1);
         int right = binarySearch(nums,  target, pivot + 1, nums.length - 1);
         if (left == -1 && right == -1){
             System.out.println(-1);
         }
         if (left == -1 && right != -1){
             System.out.println(right);
         }
        else System.out.println(left);
    }

    private static  int binarySearch(int[] a, int target, int start, int end){
        while (start <= end){
            int mid = start + (end - start)/2;
            if(a[mid] == target){
                return mid;
            } else if (a[mid] > target) {
                end = mid -1;
            }else if(a[mid] < target){
                start = mid + 1;
            }
        }
        return -1;
    }
    private static int findPivotElement(int[] nums){
        if(nums.length == 1) return 0;
        // array is not rotated
        if(nums[0] < nums[nums.length - 1]) {
            return 0;
        }
        int start = 0;
        int end = nums.length-1;
        while (start <= end){
            int mid= start + (end - start)/2;
            if(mid!=nums.length-1 && nums[mid+1]<nums[mid])
                return mid;
            if(nums[mid] > nums[nums.length-1]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }
}
