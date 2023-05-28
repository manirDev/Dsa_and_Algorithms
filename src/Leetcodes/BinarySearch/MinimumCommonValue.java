package Leetcodes.BinarySearch;

public class MinimumCommonValue {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        int[] nums2 = {2,4};
        System.out.println(getCommon(nums1, nums2));
    }
    private static int getCommon(int[] nums1, int[] nums2){
        for (int target:nums1) {
            int start = 0;
            int end = nums2.length - 1;
            while (start<=end){
                int mid = start + (end - start)/2;
                if (nums2[mid] == target){
                    return target;
                } else if (nums2[mid] > target) {
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
