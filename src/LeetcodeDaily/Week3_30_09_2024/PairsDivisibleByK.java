package LeetcodeDaily.Week3_30_09_2024;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PairsDivisibleByK {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,10,6,7,8,9};
        int k = 5;
        //boolean res = canArrangeHelper(arr, k);
        boolean res = helper(arr, k);
        System.out.println(res);
    }

    private static boolean canArrangeHelper(int[] arr, int k){
        int n = arr.length;
        int counter = 0;
        for (int i=0; i<n-1; i++){
            for (int j=i+1; j<n; j++){
                int sum = arr[i] + arr[j];
                if (sum % k == 0){
                    counter++;
                }
            }
        }
        return counter >= (n / 2) ? true : false;
    }
    private static boolean helper(int[] arr, int k){
        Map<Integer, Integer> freq = new HashMap<>();
        int n = arr.length;
        int count = 0;
        for (int num : arr) {
            int remainder = num % k;
            if (remainder < 0) {
                remainder += k;
            }
            int diff = k - remainder == k ? 0 : (k - remainder) % k;
            if (freq.getOrDefault(diff, 0) > 0) {
                count++;
                freq.put(diff, freq.get(diff) - 1);
            } else {
                freq.put(remainder, freq.getOrDefault(remainder, 0) + 1);
            }
        }
        return count >= (n / 2) ? true : false;
    }
}
