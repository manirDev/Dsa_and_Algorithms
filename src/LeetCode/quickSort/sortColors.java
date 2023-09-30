package LeetCode.quickSort;

import java.util.Arrays;

public class sortColors {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        quickSortHelper(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private static void quickSortHelper(int[] arr, int start, int end){
        if (arr.length <= 1){
            return;
        }
        int pivotIndex = partitionHelper(arr, start, end);
        if (start < pivotIndex - 1){
            quickSortHelper(arr, start, pivotIndex - 1);
        }
        if (pivotIndex < end){
            quickSortHelper(arr, pivotIndex + 1 , end);
        }
    }
    private static int partitionHelper(int[] arr, int low, int high){
       int mid = low  + (high - low) / 2;
       int pivot = arr[mid];
       while (low <= high){
           while (arr[low] < pivot){
               low++;
           }
           while (arr[high] > pivot){
               high--;
           }
           if (low <= high){
               swapHelper(arr, low, high);
               low++;
               high--;
           }
       }
        return low;
    }
    private static void swapHelper(int[] arr, int low, int high){
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }
}
