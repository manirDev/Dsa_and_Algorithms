package LeetCode.strings;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "aaaa";
        int res = longestPalindromeHelper(s);
        System.out.println(res);
    }

    private static int longestPalindromeHelper(String s) {
        Map<Character, Integer> charFreq = new HashMap<>();
        for (char c : s.toCharArray()){
            if (charFreq.containsKey(c)){
                charFreq.put(c, charFreq.get(c) + 1 );
            }else{
                charFreq.put(c, 1);
            }
        }
        int oddCharCount = 0;
        for (Map.Entry<Character, Integer> entry : charFreq.entrySet()){
            if (entry.getValue() % 2 != 0){
                oddCharCount++;
            }
        }
        return oddCharCount > 0 ? s.length() - oddCharCount + 1 : s.length();
    }
}
