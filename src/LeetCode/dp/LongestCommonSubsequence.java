package LeetCode.dp;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        int m = text1.length() + 1;
        int n = text2.length() + 1;
        int[][] table = new int[m][n];
        int res = longestCommonSubsequenceHelper(text1, text2, table);
        System.out.println(res);
    }

    private static int longestCommonSubsequenceHelper(String text1, String text2, int[][] table) {
        for (int i=text1.length()-1; i>=0; i--){
            for (int j=text2.length()-1; j>=0; j--){
                if (text1.charAt(i) == text2.charAt(j)){
                    table[i][j] = 1 + table[i+1][j+1];
                }
                else{
                    table[i][j] = Math.max(table[i+1][j], table[i][j+1]);
                }
            }
        }
        return table[0][0];
    }
}
