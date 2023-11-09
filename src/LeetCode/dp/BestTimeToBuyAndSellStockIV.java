package LeetCode.dp;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockIV {
    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
        int k = 2;
        int[][][][] memo = new int[prices.length][2][2][k + 1];
        for (int ddd[][][] : memo){
            for (int[][] dd : ddd){
                for(int[] d : dd){
                    Arrays.fill(d, -1);
                }
            }
        }
        int res = buyOrSellKTimeHelper(prices, 0, true, false, k, memo);
        System.out.println(res);
    }

    private static int buyOrSellKTimeHelper(int[] prices, int idx, boolean canBuy, boolean canSell, int k,int[][][][] memo) {
        if (idx >= prices.length || k == 0){
            return 0;
        }
        if (!canBuy && canSell && memo[idx][0][1][k] != -1){
            return memo[idx][0][1][k];
        }
        if (canBuy && !canSell && memo[idx][1][0][k] != -1){
            return memo[idx][1][0][k];
        }
        int buy = 0;
        int notBuy = 0;
        int sell = 0;
        int notSell = 0;
        if (canBuy){
            buy = buyOrSellKTimeHelper(prices, idx + 1, false, true, k,  memo) - prices[idx];
            notBuy = buyOrSellKTimeHelper(prices, idx + 1, true, false, k,  memo);
        }
        if (canSell){
            sell = buyOrSellKTimeHelper(prices, idx + 1, true, false, k - 1, memo) + prices[idx];
            notSell = buyOrSellKTimeHelper(prices, idx + 1, false, true, k, memo);
        }
        int res = Math.max(Math.max(buy, notBuy), Math.max(sell, notSell));
        if (!canBuy && canSell){
            memo[idx][0][1][k] = res;
            return memo[idx][0][1][k];
        }
        else{
            memo[idx][1][0][k] = res;
            return memo[idx][1][0][k];
        }
    }
}
