package LeetCode.dp;

import java.util.Arrays;

public class CoinChangeII {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 5;
        int[][] memo = new int[coins.length][amount + 1];
        for (int[] row : memo){
            Arrays.fill(row, -1);
        }
        int res = coinChangeHelper(coins, amount, 0, memo);
        System.out.println(res);
    }

    private static int coinChangeHelper(int[] coins, int amount, int startingIndex, int[][] memo) {
        if (amount == 0){
            return 1;
        }
        if (amount < 0 || startingIndex >= coins.length){
            return 0;
        }
        if ( memo[startingIndex][amount] != -1){
            return  memo[startingIndex][amount];
        }
        int count = 0;
        for (int i=startingIndex; i<coins.length; i++){
            count += coinChangeHelper(coins, amount - coins[i], i, memo);
        }
        memo[startingIndex][amount] = count;
        return  memo[startingIndex][amount];
    }
}
