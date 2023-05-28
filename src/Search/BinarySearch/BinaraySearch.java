package Search.BinarySearch;

public class BinaraySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{23,30,49,54,67, 78, 89, 90};
        int target = 23;
        int index = binarySearch(arr, target);
        System.out.println(index);
    }

    private static  int binarySearch(int[] a, int target){
        int start = 0;
        int end  = a.length - 1;
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
