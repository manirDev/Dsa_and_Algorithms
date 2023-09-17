package LeetCode.binarySearch;

import java.util.Arrays;

public class checkIfExist {
    public static void main(String[] args) {
        int[] arr = {3,1,7,11};
        Arrays.sort(arr);
        System.out.println(helper(arr));
    }
    private static boolean helper(int[] arr){

        for (int i=0; i<arr.length; i++){
            int start = 0;
            int end = arr.length - 1;
            int target = arr[i];
            while (start <= end){
                int mid = start + (end - start)/2;
                int num = 2*arr[mid];
                if (num == target){
                    return true;
                }
                else if(num < target){
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
        }
        return false;
    }
}
