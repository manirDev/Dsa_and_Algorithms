package LeetcodeDaily.Week1_16_09_2024;

import java.lang.reflect.Array;
import java.util.*;

public class UncommonFromSentences {
    public static void main(String[] args) {
        String s1 = "apple apple", s2 = "banana";
        String[] res = helper(s1, s2);
        System.out.println(Arrays.toString(res));
    }
    private static String[] helper(String s1, String s2){
        List<String> listRes = new ArrayList<>();
        Map<String, Integer> s1Freq = new HashMap<>();
        Map<String, Integer> s2Freq = new HashMap<>();
        for (String s : s1.split(" ")){
            s1Freq.put(s, s1Freq.getOrDefault(s, 0) + 1);
        }
        for (String s : s2.split(" ")){
            s2Freq.put(s, s2Freq.getOrDefault(s, 0) + 1);
        }
        for (String key : s1Freq.keySet()){
            if (s1Freq.get(key) == 1 && !s2Freq.containsKey(key)){
                listRes.add(key);
            }
        }
        for (String key : s2Freq.keySet()){
            if (s2Freq.get(key) == 1 && !s1Freq.containsKey(key)){
                listRes.add(key);
            }
        }
        return listRes.toArray(new String[0]);
    }
}
