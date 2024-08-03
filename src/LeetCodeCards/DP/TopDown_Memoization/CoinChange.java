package LeetCodeCards.DP.TopDown_Memoization;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -101);
        int res = minAmountHelper(coins, amount,  memo);
        if (res == Integer.MAX_VALUE){
            System.out.println(-1);
        }
        System.out.println(res);
    }

    private static int minAmountHelper(int[] coins, int amount, int[] memo) {
        if (amount < 0){
            return Integer.MAX_VALUE;
        }
        if (amount == 0){
            return  0;
        }
        if (memo[amount] != -101){
            return memo[amount];
        }

        int res = Integer.MAX_VALUE;
        for (int i=0; i<coins.length; i++){
           int count =  minAmountHelper(coins, amount - coins[i], memo);
           if (count != Integer.MAX_VALUE){
               res = Math.min(res, count + 1);
           }
        }

        memo[amount] = res;
        return memo[amount];
    }
}
