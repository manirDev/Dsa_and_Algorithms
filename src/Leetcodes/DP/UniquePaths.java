package Leetcodes.DP;

public class UniquePaths {

    public static void main(String[] args) {
        int m =51, n=6;
        int[][] memo = new int[m+1][n+1];
        System.out.println(uniquePaths(memo, m, n));
    }

    private static int uniquePaths(int[][] memo,  int m, int n){
        if(m==1 || n==1) return 1;
        if (memo[m][n] != 0) return memo[m][n];
        int down = uniquePaths(memo,m-1, n);
        int right = uniquePaths(memo, m, n-1);
        memo[m][n] = down + right;
        return memo[m][n];
    }
}
