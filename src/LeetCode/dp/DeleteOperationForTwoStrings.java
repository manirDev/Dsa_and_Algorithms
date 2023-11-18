package LeetCode.dp;

import java.util.Arrays;

public class DeleteOperationForTwoStrings {
    public static void main(String[] args) {
        String word1 = "sea";
        String word2 = "eat";
        int m = word1.length();
        int n = word2.length();
        int[][] table = new int[word1.length() + 1][word2.length() + 1];
        for (int i=0; i<=m; i++){
            table[i][n] = m - i;
        }
        for (int i=0; i<=n; i++){
            table[m][i] = n - i;
        }
        for (int[] row : table){
            System.out.println(Arrays.toString(row));
        }
        int res = minDistanceHelper(word1, word2, table);
        System.out.println(res);
    }

    private static int minDistanceHelper(String word1, String word2, int[][] table) {
        for (int i=word1.length()-1; i>=0; i--){
            for (int j=word2.length()-1; j>=0; j--){
                if (word1.charAt(i) == word2.charAt(j)){
                    table[i][j] = table[i+1][j+1];
                }
                else{
                    table[i][j] = Math.min(table[i+1][j], table[i][j+1]) + 1;
                }
            }
        }
        return table[0][0];
    }
}
