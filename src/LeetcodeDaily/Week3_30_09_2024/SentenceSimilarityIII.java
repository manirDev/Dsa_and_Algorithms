package LeetcodeDaily.Week3_30_09_2024;

import java.util.HashMap;
import java.util.Map;

public class SentenceSimilarityIII {
    public static void main(String[] args) {
        String sentence1 = "Luky";
        String sentence2 = "Lucccky";
        System.out.println(sentence1.split("").length);
        boolean res = helper(sentence1, sentence2);
        System.out.println(res);
    }
    private static boolean helper(String sentence1, String sentence2){
        if (sentence1.equals(sentence2)) {
            return true;
        }

        String[] arr1 = sentence1.split(" ");
        String[] arr2 = sentence2.split(" ");

        // Always compare shorter sentence to the longer one
        if (arr1.length > arr2.length) {
            return helper(sentence2, sentence1);
        }

        int left = 0, right = 0;
        int n = arr1.length, m = arr2.length;

        while (left < n && arr1[left].equals(arr2[left])) {
            left++;
        }

        while (right < n && arr1[n - 1 - right].equals(arr2[m - 1 - right])) {
            right++;
        }

        return left + right >= n;
    }
    private static boolean helper1(String sentence1, String sentence2){
        if (sentence1.isEmpty() || sentence2.isEmpty()){
            return true;
        }

        Map<Integer, String> sentence1Freq = new HashMap<>();
        Map<Integer, String> sentence2Freq = new HashMap<>();
        String[] arr = sentence1.split(" ");
        for (int i=0; i<arr.length; i++){
            sentence1Freq.put(i, arr[i].toLowerCase());
        }
        arr = sentence2.split(" ");
        for (int i=0; i<arr.length; i++){
            sentence2Freq.put(i, arr[i].toLowerCase());
        }
        if (sentence1Freq.size() == 1 && sentence1Freq.size() == 1){
            return false;
        }
        for (int i=0; i<arr.length-1; i++){
            if (sentence1Freq.containsKey(i)){
                if (sentence2Freq.containsKey(i+1) && sentence2Freq.containsKey(i-1)){
                    return false;
                }
            }
        }
        return true;
    }
}
