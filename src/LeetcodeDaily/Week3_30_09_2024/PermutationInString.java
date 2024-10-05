package LeetcodeDaily.Week3_30_09_2024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermutationInString {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidboaoo";
        List<String> permutations = new ArrayList<>();
        permutationHelper(s1, permutations, new StringBuilder(), new boolean[s1.length()]);
        boolean res = checkInclusionHelper(permutations, s2);
        System.out.println(res);
    }

    private static boolean helper(String s1, String s2){
        int n = s1.length(), m = s2.length();
        if (n > m) return false;

        Map<Character, Integer> s1Feq = new HashMap<>();
        for (char c : s1.toCharArray()) {
            s1Feq.put(c, s1Feq.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> s2Feq = new HashMap<>();
        for (int i = 0; i < m; i++) {
            char currChar = s2.charAt(i);
            s2Feq.put(currChar, s2Feq.getOrDefault(currChar, 0) + 1);
            if (i >= n) {
                char toBeRemoved = s2.charAt(i - n);
                if (s2Feq.get(toBeRemoved) == 1) {
                    s2Feq.remove(toBeRemoved);
                }
                else {
                    s2Feq.put(toBeRemoved, s2Feq.get(toBeRemoved) - 1);
                }
            }

            if (s1Feq.equals(s2Feq)) {
                return true;
            }
        }

        return false;
    }

    private static boolean checkInclusionHelper(List<String> permutations, String s){
        int len = permutations.get(0).length();
        for (int i=0; i<s.length() - 1; i++){
            String subStr = s.substring(i, len + i);
            if (permutations.contains(subStr)){
                return true;
            }
        }
        return false;
    }
    private static void permutationHelper(String s, List<String> list, StringBuilder sb, boolean[] visited){
        if (sb.length() == s.length()){
            list.add(sb.toString());
            return;
        }
        for (int i=0; i<s.length(); i++){
            if (visited[i]){
                continue;
            }
            sb.append(String.valueOf(s.charAt(i)));
            visited[i] = true;
            permutationHelper(s, list, sb, visited);
            sb.deleteCharAt(sb.length() - 1);
            visited[i] = false;
        }
    }
}
