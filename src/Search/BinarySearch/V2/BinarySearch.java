package Search.BinarySearch.V2;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 6, 7, 8, 9, 11};
        List<Integer> list =new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(11);
        int target = 11;

  //      System.out.println("Iterative Function:");
//        long time = System.currentTimeMillis();
//        System.out.println(helper(nums, target));
//        System.out.printf("Time using Iteration: %d ms\n", System.currentTimeMillis() - time);
        System.out.println("Array: " + helper(nums, target));
        System.out.println("ArrayList: " + arrayListHelper(list, target));

    }

    private static int helper(int[] a, int t){
        int s = 0;
        int e = a.length - 1;
        while(s <= e){
            int mid = s  + (e - s)/2;
            if (a[mid] == t){
                return mid;
            }
            else if(a[mid] < t){
                s = mid + 1;
            }
            else {
                e = mid - 1;
            }
        }
        return -1;
    }
    private static int arrayListHelper(List<Integer> list, int t){
        int s = 0;
        int e = list.size() - 1;
        while(s <= e){
            int mid = s  + (e - s)/2;
            if (list.get(mid) == t){
                return mid;
            }
            else if(list.get(mid) < t){
                s = mid + 1;
            }
            else {
                e = mid - 1;
            }
        }
        return -1;
    }
}
