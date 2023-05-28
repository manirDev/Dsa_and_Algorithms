package Leetcodes.DP;

public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 2;
        System.out.println(climbStair(n));
    }

    private static int climbStair(int n){
//        if (n==1 || n==2){
//            return n;
//        }
//        return climbStair(n - 1) + climbStair(n - 2);

        if (n == 1 || n==2) return n;
        int[] memo = new int[n+1];
        memo[0] = 1;
        memo[1] = 1;
        for (int i=2; i<n+1; i++){
            memo[i] = memo[i-1] + memo[i-2];
        }
        return memo[n];
    }
}
