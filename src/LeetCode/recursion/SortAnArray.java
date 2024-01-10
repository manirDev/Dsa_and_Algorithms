package LeetCode.recursion;

import java.util.Arrays;

public class SortAnArray {
    public static void main(String[] args) {
        int[] nums = {5,2,3,1};
        int[] res = sortHelper(nums);
        System.out.println(Arrays.toString(res));
    }

    private static int[] sortHelper(int[] nums) {
        if (nums.length == 1){
            return nums;
        }
        int pivot = nums.length / 2;
        int[] left_nums = sortHelper(Arrays.copyOfRange(nums, 0, pivot));
        int[] right_nums = sortHelper(Arrays.copyOfRange(nums, pivot, nums.length));
        return mergeHelper(left_nums, right_nums);
    }
    private static int[] mergeHelper(int[] left, int[] right){
        int m = left.length, n = right.length, i = 0, j = 0, k = 0;
        int[] res = new int[m + n];
        while (i < m && j < n){
            if (left[i] < right[j]){
                res[k++] = left[i++];
            }
            else{
                res[k++] = right[j++];
            }
        }
        while (i < m){
            res[k++] = left[i++];
        }while (j < n){
            res[k++] = right[j++];
        }
        return res;
    }
}
