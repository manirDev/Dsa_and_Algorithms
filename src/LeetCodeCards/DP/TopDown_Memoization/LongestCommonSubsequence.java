package LeetCodeCards.DP.TopDown_Memoization;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        int[][] memo = new int[text1.length() + 1][text2.length() + 1];
        for (int[] row : memo){
            Arrays.fill(row, -101);
        }
        int res = lcsHelper(text1, text2, 0, 0, memo);
        System.out.println(res);
    }

    private static int lcsHelper(String text1, String text2, int idx1, int idx2, int[][] memo) {
        if (idx1 >= text1.length() || idx2 >= text2.length()){
            return 0;
        }
        if (memo[idx1][idx2] != -101){
            return memo[idx1][idx2];
        }
        if (text1.charAt(idx1) == text2.charAt(idx2)){
            return 1 + lcsHelper(text1, text2, idx1 + 1, idx2 + 1, memo);
        }
        memo[idx1][idx2] = Math.max(lcsHelper(text1, text2, idx1 + 1, idx2, memo), lcsHelper(text1, text2, idx1, idx2 + 1, memo));
        return memo[idx1][idx2];
    }
}
