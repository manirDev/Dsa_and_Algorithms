package LeetcodeDaily.Week3_30_09_2024;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayRankTransform {
    public static void main(String[] args) {
        int[] arr = {37,12,28,9,100,56,80,5,12};
        int[] res = helper(arr);
        System.out.println(Arrays.toString(res));
    }
    private static int[] helper(int[] arr){
        int[] res = new int[arr.length];
        Map<Integer, Integer> sortedIndices = new HashMap<>();

        for (int i=0; i<arr.length; i++){
            res[i] = arr[i];
        }
        Arrays.sort(arr);
        int idx = 1;
        for (int i=0; i<arr.length; i++){
            if (sortedIndices.containsKey(arr[i])){
                continue;
            }
            else{
                sortedIndices.put(arr[i], idx++);
            }
        }
        for (int i=0; i<res.length; i++){
            int indice = sortedIndices.get(res[i]);
            res[i] = indice;
        }
        return res;
    }
}
