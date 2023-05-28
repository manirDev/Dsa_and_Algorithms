package Leetcodes.BinarySearch;

public class SearchInRotatedSortedArrayII {
    public static void main(String[] args) {
        int[] arr = {2,5,6,0,0,1,2};
        int target = 10;
        int pivot = findPivot(arr);
        boolean left = leftArrayBinarySearch(arr, 0, pivot-1, target);
        boolean right = rightArrayBinarySearch(arr, pivot+1, arr.length-1, target);
        if (left || right || arr[pivot]==target){
            System.out.println("True");
        }else {
            System.out.println("False");
        }
    }

    private static int findPivot(int[] a){
        int start = 0;
        int end = a.length - 1;
        while(start<=end){
            int mid = start + (end - start)/2;
            if(mid < end && a[mid] > a[mid+1]){
                return mid;
            }else if (mid > start && a[mid] < a[mid-1]){
                return mid - 1;
            }else if (a[mid] <= a[start]){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return start;
    }
    private static  boolean leftArrayBinarySearch(int[] a, int start, int end, int target){
        while (start <= end){
            int mid = start + (end - start)/2;

            if(a[mid] == target){
                return true;
            }
            if(a[mid]==a[start]&&a[mid]==a[end]){
                start++;
                end--;
            }else if (a[mid] > target) {
                end = mid -1;
            }else if(a[mid] < target){
                start = mid + 1;
            }
        }
        return false;
    }


    private static  boolean rightArrayBinarySearch(int[] a, int start, int end, int target){
        while (start <= end){
            int mid = start + (end - start)/2;

            if(a[mid] == target){
                return true;
            }
            if(a[mid]==a[start]&&a[mid]==a[end]){
                start++;
                end--;
            }else if (a[mid] > target) {
                end = mid -1;
            }else if(a[mid] < target){
                start = mid + 1;
            }
        }
        return false;
    }
}
