package LeetCode.dp;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String s = "bbbab";
        StringBuilder sb = new StringBuilder(s);
        int m = s.length() + 1;
        int[][] table = new int[m][m];
        int res = longestCommonSubsequenceHelper(s, sb.reverse().toString(), table);
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
