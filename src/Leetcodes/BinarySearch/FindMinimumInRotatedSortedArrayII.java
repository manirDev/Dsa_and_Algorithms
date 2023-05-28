package Leetcodes.BinarySearch;

public class FindMinimumInRotatedSortedArrayII {
    public static void main(String[] args) {
        int[] arr = {1,3,5};
        int min = helper(arr);
        System.out.println(min);
    }
    private static int helper(int[] a){
        int start = 0;
        int end = a.length - 1;
        //it is like the array was not rotated
        if(a[start] <= a[end]){
            return a[start];
        }
        while(start <= end){
            int mid = start + (end - start)/2;
            if(a[mid] > a[end]){
                start = mid + 1;
            }else if(a[mid] < a[end]){
                end = mid - 1;
            }else{
                end = end - 1;
            }
        }
        return a[start];
    }
}
