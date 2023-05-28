package Leetcodes.BinarySearch;

public class SearchInsertionPosition {
    public static void main(String[] args) {
        int[] arr = {1,3,5,6};
        /**
            if: arr[mid]==target => return mid
            if: arr[mid]>target&&target>arr[mid-1]=>end=mid-1;
            if: arr[mid]<target&&target<arr[mid+1]=>start=mid+1;

        **/
        int target = 2;
        int index = helper(arr, target);
        if(arr[index]==target){
            System.out.println(target + " found in the array at: " + index);
        }else {
            System.out.println(target + " it can be inserted at: " + index);
        }
    }

    private static  int helper(int[] a, int target){
        if(target < a[0]){
            return 0;
        }
        if (target > a[a.length -1]){
            return a.length;
        }
        int start = 0;
        int end = a.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(a[mid] == target){
                return mid;
            } else if (a[mid]>target) {
                end = mid - 1;
                if (target>a[mid-1]){
                    return mid;
                }
            }else {
                start = mid + 1;
                if (target<a[mid+1]){
                    return mid+1;
                }
            }
        }
        return start;
    }
}
