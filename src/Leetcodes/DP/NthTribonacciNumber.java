package Leetcodes.DP;

/**
 The Tribonacci sequence Tn is defined as follows:

 T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.

 Given n, return the value of Tn
 */
public class NthTribonacciNumber {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(tribonacci(n));
    }

    private static int tribonacci(int n){
//        int[] memo = new int[n+1];
//        if (n == 0) return 0;
//        if (n==1 || n==2) return 1;
//        if (memo[n] != 0) return memo[n];
//        memo[n] = tribonacci(n - 3) + tribonacci(n - 2) + tribonacci(n - 1);
//        return memo[n];

        int[] memo = new int[n+1];
        if (n == 0) return 0;
        if (n==1 || n==2) return 1;
        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 1;
        for (int i=3; i<n+1; i++){
            memo[i] = memo[i-3] + memo[i-2] + memo[i-1];
        }
        return memo[n];
    }
}
