package LeetcodeDaily.Week2_23_09_2024;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ExtraCharactersInAString {
    public static void main(String[] args) {
        String s = "leetscode";
        String[] dictionary = {"leet","code","leetcode"};
        Map<Integer, Integer> memo = new HashMap<>();
        // Base case: No extra char at the end
        memo.put(s.length(), 0);
        int res = helper(s, new HashSet<>(Set.of(dictionary)), 0, memo);
        System.out.println(res);
    }
    private static int helper(String s, Set<String> dic, int start, Map<Integer, Integer> memo){
        if (memo.containsKey(start)){
            return memo.get(start);
        }

        int minExtra = 1 + helper(s, dic, start + 1, memo);

        for (int end = start + 1; end <= s.length(); end++){
            String subStr = s.substring(start, end);
            if (dic.contains(subStr)){
                minExtra = Math.min(minExtra, helper(s, dic, end, memo));
            }
        }
        memo.put(start, minExtra);
        return memo.get(start);
    }
}
