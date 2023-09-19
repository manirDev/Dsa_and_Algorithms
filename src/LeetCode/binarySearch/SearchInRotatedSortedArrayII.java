package LeetCode.binarySearch;

public class SearchInRotatedSortedArrayII {
    public static void main(String[] args) {
        int[] nums = {2,5,6,0,0,1,2};
        int target = 0;
        int pivot = findPivotElement(nums);
        System.out.println(pivot);
        if (pivot == -1){
            System.out.println(binarySearch(nums,  target, 0, nums.length - 1));
        }
        if(target == nums[pivot]){
            System.out.println(true); ;
        }
        boolean left = binarySearch(nums,  target, 0, pivot - 1);
        boolean right = binarySearch(nums,  target, pivot + 1, nums.length - 1);
        if (target >= nums[0]){
            System.out.println(left);
        }

        else{
            System.out.println(right);;
        }
    }

    private static  boolean binarySearch(int[] a, int target, int start, int end){
        while (start <= end){
            int mid = start + (end - start)/2;
            if(a[mid] == target){
                return true;
            } else if (a[mid] > target) {
                end = mid -1;
            }else if(a[mid] < target){
                start = mid + 1;
            }
        }
        return false;
    }

    private static int findPivotElement(int[] nums){
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            int mid = start + (end - start)/2;
            //first two are the cases when the pivot is found
            if (mid < end && nums[mid] > nums[mid + 1]){
                return mid;
            }
            if (mid > start && nums[mid] < nums[mid - 1]){
                return mid - 1;
            }
            //case when start, mid, and end point to indexes containing the same number
            if (nums[start] == nums[mid] && nums[mid] == nums[end]){
                //skip the duplicates
                //what if the start was the pivot?
                if (start < end && nums[start] > nums[start + 1]){
                    return start;
                }//else
                start++;

                //what if the end was the pivot?
                if (end > start && nums[end- 1] > nums[end]){
                    return end - 1;
                }
                end--;
            }//case when we need to search on the right side to check for pivot
            else if (nums[start] < nums[mid] || (nums[start] == nums[mid] && nums[mid] > nums[end])){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        //if array is not rotated
        return -1;
    }

}
