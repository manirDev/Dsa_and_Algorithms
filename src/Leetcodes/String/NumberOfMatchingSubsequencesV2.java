package Leetcodes.String;

import java.util.HashMap;

public class NumberOfMatchingSubsequencesV2 {
    public static void main(String[] args) {
        String s = "abcde";
        String[] words = {"a","bb","acd","ace"};
        System.out.println(numMatchingSubseq(s, words));
    }

    public static int numMatchingSubseq(String s, String[] words){
        int count = 0;
        HashMap<String, Integer> mapper = new HashMap<>();
        for (String word: words) {
            mapper.put(word, mapper.getOrDefault(word, 0) + 1);
        }
        char[] sArray = s.toCharArray();
        for (String word: mapper.keySet()) {
            int i = 0;
            int j = 0;
            char[] wArray = word.toCharArray();
            while(i<sArray.length && j<wArray.length){
                if (wArray[j] == sArray[i]){
                    j++;
                    i++;
                }
                else {
                    i++;
                }
            }
            if(j == wArray.length){
                count += mapper.get(word);
            }
        }
        return count;
    }
}
