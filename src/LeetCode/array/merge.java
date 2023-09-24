package LeetCode.array;

import java.util.Arrays;

public class merge {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3, n = 3;
        System.out.println(Arrays.toString(mergeHelper(nums1, m, nums2, n)));
    }
    private static int[] mergeHelper(int[] nums1, int m, int[] nums2, int n){
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0 && k >= 0){
            if (nums1[i] > nums2[j]){
                nums1[k] = nums1[i];
                k--;
                i--;
            }else {
                nums1[k] = nums2[j];
                k--;
                j--;
            }
        }

        return nums1;
    }
}
