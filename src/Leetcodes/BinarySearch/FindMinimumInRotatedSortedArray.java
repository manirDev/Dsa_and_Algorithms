package Leetcodes.BinarySearch;

public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {11,13,15,17};
        System.out.println(helper(arr));
    }

    private static int helper(int[] a){
        int start = 0;
        int end = a.length - 1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(mid<end && a[mid]>a[mid+1]){
                return a[mid+1];
            }else if(mid>start && a[mid]<a[mid-1]){
                return a[mid];
            } else if (a[mid]<=a[start]) {
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return a[0];
    }
}
