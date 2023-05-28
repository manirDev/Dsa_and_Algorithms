package Leetcodes;

import java.util.ArrayList;
import java.util.List;

public class SumOfSubarrayMinimums {
    public static void main(String[] args) {
        int[] arr = {3,1,2,4};
        System.out.println(sumSubarrayMins(arr));
    }

    private static int sumSubarrayMins(int[] arr){
        int sum = 0;
        for(int i=0; i<arr.length-1; i++){
            List<Integer> temp = new ArrayList<>();
            for (int j=arr.length-1; j>=i; j--){
                temp.add(arr[j]);
            }
            int min = Integer.MAX_VALUE;
            List<Integer> minList = new ArrayList<>();
            for (int e: temp) {
                if (e < min){
                    min = e;
                    minList.add(min);
                }
            }
            for (int e: minList) {
                sum = sum + e;
            }
        }
        return sum % (10^9 + 7);
    }
}
