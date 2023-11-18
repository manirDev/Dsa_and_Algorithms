package LeetCode.dp;

public class EditDistance {
    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        int m = word1.length();
        int n = word2.length();
        int[][] table = new int[m + 1][n + 1];
        for (int i=0; i<=m; i++){
            table[i][n] = m - i;
        }
        for (int i=0; i<=n; i++){
            table[m][i] = n - i;
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
                    int insert = table[i][j+1];
                    int delete = table[i+1][j];
                    int replace = table[i+1][j+1];
                    table[i][j] = Math.min(insert, Math.min(delete, replace)) + 1;
                }
            }
        }
        return table[0][0];
    }
}
