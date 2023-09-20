package LeetCode.mergeSort;

import java.util.Arrays;

public class sortArray {
    public static void main(String[] args) {
        int[] nums = {5,2,3,1};
        int[] res = splitHelper(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(res));
    }
    private static int[] splitHelper(int[] nums){
        int len = nums.length;
        if (len <= 1){
            return nums;
        }
        int mid = len / 2;
        int[] left = splitHelper(Arrays.copyOfRange(nums, 0, mid));
        int[] right = splitHelper(Arrays.copyOfRange(nums, mid, len));

        return mergeHelper(left, right);
    }
    private static int[] mergeHelper(int[] left, int[] right){
        int n = left.length;
        int m = right.length;
        int[] res = new int[n + m];
        int i = 0, j = 0, k = 0;
        while (i<n && j<m){
            if (left[i] < right[j]){
                res[k] = left[i];
                i++;
                k++;
            }
            else {
                res[k] = right[j];
                j++;
                k++;
            }
        }
        while (i<n){
            res[k] = left[i];
            i++;
            k++;
        }
        while (j<m){
            res[k] = right[j];
            j++;
            k++;
        }
        return res;
    }
}
