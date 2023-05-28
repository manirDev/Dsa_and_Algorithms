package Search.BinarySearch;

public class OrderAgnostic {
    public static void main(String[] args) {
        int[] arr_asc = new int[] {23,30,49,54,67,78,89,90};
        int[] arr_desc = new int[] {90,89,78,67,54,49,30,23};
        int target = 89;
        int index_asc = binarySearch(arr_asc, target);
        int index_desc = binarySearch(arr_desc, target);
        System.out.println("ASC: " + index_asc);
        System.out.println("DESC: " + index_desc);
    }

    private static  int binarySearch(int[] a, int target){
        int start = 0;
        int end  = a.length - 1;
        int index = -1;
        boolean asc = a[start] < a[end];
        while (start <= end){
            int mid = start + (end - start)/2;

            if(a[mid] == target){
                index = mid;
                return index;
            }
            else if(asc){
                if(a[mid] > target){
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
            }
            else {
                if(a[mid] > target){
                    start = mid+1;
                }else {
                    end = mid - 1;
                }
            }
        }
        return index;
    }
}
