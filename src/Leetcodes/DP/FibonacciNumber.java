package Leetcodes.DP;

import java.util.HashMap;

public class FibonacciNumber {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(fib(n));
    }

    private static int fib(int n){
//        HashMap<Integer, Integer> memo = new HashMap<>();
//        if(memo.containsKey(n)) return memo.get(n);
//        if (n <= 2) return 1;
//        memo.put(n, fib(n-1) + fib(n-2));
//        return memo.get(n);

//        int[] memo = new int[n+1];
//        if (n <= 1) return n;
//        memo[0] = 0;
//        memo[1] = 1;
//        for (int i=2; i<n+1; i++){
//            memo[i] = memo[i-1] + memo[i-2];
//        }
//        if(n <= 2) return 1;
//        else{
//            memo[n] =  fib(n - 1) + fib(n - 2);
//            return memo[n];
//        }
       // return memo[n];

        int[] memo = new int[n+1];
        if (memo[n] !=0) return memo[n];
        if (n <= 2) return 1;
        memo[n] =  fib(n - 1) + fib(n - 2);
        return memo[n];

    }
}
