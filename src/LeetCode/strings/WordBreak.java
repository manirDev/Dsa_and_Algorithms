package LeetCode.strings;

import java.util.*;

public class WordBreak {
    public static void main(String[] args) {
        String s = "applepenapple";
        List<String> wordDict = new ArrayList<>(Arrays.asList("apple","pen"));
        Set<String> res = new HashSet<>();
        sequenceHelper(s, wordDict, res, new StringBuilder(), 0);
        System.out.println(res);
    }

    private static void sequenceHelper(String s, List<String> wordDict, Set<String> res, StringBuilder sb, int idx) {
        if (idx >= s.length()){
            if (!res.contains(sb.toString())){
                res.add(sb.toString());
            }
            return;
        }
        for (String word : wordDict){
            if (s.substring(idx, idx + word.length()).equals(word)){
                sb.append(word).append(" ");
                sequenceHelper(s, wordDict, res, sb, idx + word.length());
                sb.delete(idx, word.length() + idx);
            }
        }
    }
}
