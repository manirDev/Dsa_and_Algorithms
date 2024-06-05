package LeetCode.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonChars {
    public static void main(String[] args) {
        String[] words = {"bella", "label", "roller"};
        List<String> res = commonCharsHelper(words);
        System.out.println(res);
    }

    private static List<String> commonCharsHelper(String[] words) {
        List<String> res =  new ArrayList<>();
        Map<Character, Integer> charFreq  = new HashMap<>();
        Map<Character, Integer> freq  = new HashMap<>();
        for (char c : words[0].toCharArray()){
            charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
        }
        for (int i=1; i<words.length; i++) {
            for (char c : words[i].toCharArray()) {
                freq.put(c, freq.getOrDefault(c, 0) + 1);
            }
        }
        for (char key : charFreq.keySet()){
            int value = charFreq.get(key);
            if (freq.containsKey(key) && freq.get(key) == (value * (words.length - 1))){
                int i = 0;
                while (i < value){
                    res.add(String.valueOf(key));
                    i++;
                }
            }
        }
        return res;
    }
}
