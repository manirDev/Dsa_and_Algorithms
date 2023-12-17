package LeetCode.slindingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {
    public static void main(String[] args) {
        String s = "eceba";
        int k = 2;
        int res = helper(s, k);
        System.out.println(res);
    }
    private static int helper(String s, int k){
        Map<Character, Integer> window = new HashMap<>();
        int right = 0, left = 0, res = 0;
        while (right < s.length()){
            window.put(s.charAt(right), window.getOrDefault(s.charAt(right), 0) + 1);
            while (window.size() > k){
                removeElementFromWindow(window, s.charAt(left));
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }

    private static void removeElementFromWindow(Map<Character, Integer> window, char c) {
        Integer count = window.get(c);
        if (count != null && count > 1){
            window.put(c, count - 1);
        }else{
            window.remove(c);
        }
    }
}
