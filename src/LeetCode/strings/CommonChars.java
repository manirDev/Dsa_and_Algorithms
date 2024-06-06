package LeetCode.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonChars {
    public static void main(String[] args) {
        String[] words = {"cool","lock","cook"};
        List<String> res = commonCharsHelper(words);
        System.out.println(res);
    }

    private static List<String> commonCharsHelper(String[] words) {
        List<String> res =  new ArrayList<>();
        Map<Character, Integer> commonFreq  = new HashMap<>();
        for (char c : words[0].toCharArray()){
            commonFreq.put(c, commonFreq.getOrDefault(c, 0) + 1);
        }
        for (int i=1; i<words.length; i++) {
            Map<Character, Integer> tempFreq  = new HashMap<>();
            for (char c : words[i].toCharArray()) {
                tempFreq.put(c, tempFreq.getOrDefault(c, 0) + 1);
            }
            Map<Character, Integer> minFreq  = new HashMap<>();
            for (char key : commonFreq.keySet()) {
                if (tempFreq.containsKey(key)) {
                    int value = Math.min(commonFreq.get(key), tempFreq.get(key));
                    minFreq.put(key, value);
                }
            }
            commonFreq = minFreq;
        }
        for (char key : commonFreq.keySet()){
            int value = commonFreq.get(key);
            int i = 0;
            while (i < value){
                res.add(String.valueOf(key));
                i++;
            }
        }
        return res;
    }
}
