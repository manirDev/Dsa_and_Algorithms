package Leetcodes.BinarySearch;

public class SearchInRotatedArray {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        int target = 7;
        int pivot = findPivot(arr);
        int leftArray = leftArrayBinarySearch(arr, 0, pivot-1, target);
        int rightArray = rightArrayBinarySearch(arr, pivot+1, arr.length-1, target);
        System.out.println("Pivot: " + pivot);
        if(target==arr[pivot]){
            System.out.println("Target==Pivot: " + arr[pivot]);
        }

        System.out.println("Left: " + leftArray);
        System.out.println("Right: " + rightArray);
    }
    private static int findPivot(int[] a){
        int start = 0;
        int end = a.length - 1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(mid<end && a[mid]>a[mid+1]){
                return mid;
            }else if(mid>start && a[mid]<a[mid-1]){
                return mid-1;
            } else if (a[mid]<=a[start]) {
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return -1;
    }
    private static  int leftArrayBinarySearch(int[] a, int start, int end , int target){
        int index = -1;
        while (start <= end){
            int mid = start + (end - start)/2;

            if(a[mid] == target){
                index = mid;
                return index;
            } else if (a[mid] > target) {
                end = mid -1;
            }else if(a[mid] < target){
                start = mid + 1;
            }
        }
        return index;
    }
    private static  int rightArrayBinarySearch(int[] a, int start, int end , int target){
        int index = -1;
        while (start <= end){
            int mid = start + (end - start)/2;

            if(a[mid] == target){
                index = mid;
                return index;
            } else if (a[mid] > target) {
                end = mid -1;
            }else if(a[mid] < target){
                start = mid + 1;
            }
        }
        return index;
    }
}
