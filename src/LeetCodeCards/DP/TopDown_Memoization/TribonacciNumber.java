package LeetCodeCards.DP.TopDown_Memoization;

import java.util.Arrays;

public class TribonacciNumber {
    public static void main(String[] args) {
        int n = 4;
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -101);
        int res = tribonacciHelper(n, memo);
        System.out.println(res);
    }

    private static int tribonacciHelper(int n, int[] memo) {
        if (n == 0 ){
            return 0;
        }
        if (n == 1 || n == 2){
            return 1;
        }
        if (memo[n] != -101){
            return memo[n];
        }
        int res = tribonacciHelper(n - 3, memo) + tribonacciHelper(n - 2, memo) + tribonacciHelper(n - 1, memo);
        memo[n] = res;
        return memo[n];
    }
}
