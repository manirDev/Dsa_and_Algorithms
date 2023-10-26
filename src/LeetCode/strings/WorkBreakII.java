package LeetCode.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorkBreakII {
    public static void main(String[] args) {
        String s = "pineapplepenapple";
        List<String> wordDict = new ArrayList<>(Arrays.asList("apple","pen","applepen","pine","pineapple"));
        List<String> res = new ArrayList<>();
        splitHelper(s, wordDict, new ArrayList<>(), res, 0);
        System.out.println(res);
    }

    private static void splitHelper(String s, List<String> wordDict, List<String> list, List<String> res, int idx) {
        if (idx >= s.length()){
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<list.size(); i++){
                sb.append(list.get(i));
                if (i != list.size() - 1){
                    sb.append(" ");
                }
            }
            res.add(sb.toString());
            return;
        }
        for (String word : wordDict){
            if (s.substring(idx).startsWith(word)){
                list.add(word + " ");
                splitHelper(s, wordDict, list, res, idx + word.length());
                list.remove(list.size() - 1);
            }
        }
    }
}
