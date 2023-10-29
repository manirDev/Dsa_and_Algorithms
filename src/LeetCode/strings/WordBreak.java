package LeetCode.strings;

import java.util.*;

public class WordBreak {
    public static void main(String[] args) {
        String s = "applepenapple";
        List<String> wordDict = new ArrayList<>(Arrays.asList("apple","pen"));
        boolean res = sequenceHelper(s, wordDict, new HashMap<>(), 0);
        System.out.println(res);

    }

    private static boolean sequenceHelper(String s, List<String> wordDict, Map<String, Boolean> memo, int idx) {
        if (s.equals("")){
            return true;
        }
        if (memo.containsKey(s)){
            return memo.get(s);
        }
        for (String word : wordDict){
            if (s.startsWith(word)){
                idx = word.length();
                String newString = s.substring(idx);
                if (sequenceHelper(newString, wordDict, memo, idx)){
                    memo.put(s, true);
                    return memo.get(s);
                }
            }
        }
        memo.put(s,  false);
        return memo.get(s);
    }
}
