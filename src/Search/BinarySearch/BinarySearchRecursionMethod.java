package Search.BinarySearch;

public class BinarySearchRecursionMethod {
    public static void main(String[] args) {
        int[] arr = new int[]{23,30,49,54,67, 78, 89, 90};
        int target = 23;
        int start = 0;
        int end  = arr.length - 1;
        int index = binarySearch(arr, start, end, target);
        System.out.println(index);
    }

    private static  int binarySearch(int[] a, int start, int end, int target){

        int index = -1;
        if(start > end){
            return index;
        }
        int mid = start + (end - start)/2;

        if(a[mid] > target){
            return binarySearch(a, start, mid-1, target);
        }
        else if (a[mid] < target){
            return binarySearch(a, mid+1, end, target);
        }
        else {
            index = mid;
            return index;
        }
    }
}
