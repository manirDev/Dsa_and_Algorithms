package Leetcodes.Arrays;

/***
 Given an array of integers arr and two integers k and threshold, return the number of sub-arrays
 of size k and average greater than or equal to threshold.
 */
public class NumOfSubarrays {
    public static void main(String[] args) {
        int[] arr = {2,2,2,2,5,5,5,8};
        int k = 3, threshold = 4;
        System.out.println(numOfSubArrays(arr, k, threshold));
    }

    private static int numOfSubArrays(int[] arr, int k, int threshold){
        int count = 0;
        int len = arr.length;
        int i = 0;
        int sum = 0;
        while(i < k){
            sum += arr[i];
            i++;
        }
        if(sum/k >= threshold){
            count++;
        }
        while(i < len){
            sum -= arr[i - k];
            sum += arr[i];
            if(sum/k >= threshold){
                count++;
            }
            i++;
        }
        return count;
    }
}
