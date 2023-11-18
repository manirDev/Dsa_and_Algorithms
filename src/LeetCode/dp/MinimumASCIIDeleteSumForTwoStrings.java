package LeetCode.dp;

import javax.swing.plaf.metal.MetalTheme;

public class MinimumASCIIDeleteSumForTwoStrings {
    public static void main(String[] args) {
        String word1 = "ccaccjp";
        String word2 = "fwosarcwge";
        int m = word1.length();
        int n = word2.length();
        int[][] table = new int[m+1][n+1];
        for (int i=m-1; i>=0; i--){
            table[i][n] = table[i+1][n] + word1.charAt(i);
        }
        for (int i=n-1; i>=0; i--){
            table[m][i] = table[m][i+1] + word2.charAt(i);
        }
        int res = minimumDeleteSumHelper(word1, word2, table);
        System.out.println(res);
    }

    private static int minimumDeleteSumHelper(String word1, String word2, int[][] table) {
        for (int i=word1.length()-1; i>=0; i--){
            for (int j=word2.length()-1; j>=0; j--){
                if (word1.charAt(i) == word2.charAt(j)){
                    table[i][j] = table[i+1][j+1];
                }
                else{
                    int w1DeletedChar = word1.charAt(i) + table[i+1][j];
                    int w2DeletedChar = word2.charAt(j) + table[i][j+1];
                    table[i][j] = Math.min(w1DeletedChar, w2DeletedChar);
                }
            }
        }
        return table[0][0];
    }
}
