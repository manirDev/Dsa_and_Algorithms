package LeetCode.strings;

public class AppendCharacters {
    public static void main(String[] args) {
        String s = "coaching";
        String t = "coding";
        int res = appendCharsHelper(s, t);
        System.out.println(res); // Output should be 4
    }

    private static int appendCharsHelper(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return n - dp[m][n];
    }
}
