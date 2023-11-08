package LeetCode.dp;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockIII {
    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
        int[][][][] memo = new int[prices.length][2][2][3];
        for (int ddd[][][] : memo){
            for (int[][] dd : ddd){
                for(int[] d : dd){
                    Arrays.fill(d, -1);
                }
            }
        }
        int res = limitedBuyOrSellHelper(prices, 0, true, false, 2, memo);
        System.out.println(res);
    }

    private static int limitedBuyOrSellHelper(int[] prices, int idx, boolean canBuy, boolean canSell, int limit, int[][][][] memo) {
        if (idx >= prices.length || limit == 0){
            return 0;
        }
        if (!canBuy && canSell && memo[idx][0][1][limit] != -1){
            return memo[idx][0][1][limit];
        }
        if (canBuy && !canSell && memo[idx][1][0][limit] != -1){
            return memo[idx][1][0][limit];
        }
        int buy = 0;
        int notBuy = 0;
        int sell = 0;
        int notSell = 0;
        if (canBuy){
            buy = limitedBuyOrSellHelper(prices, idx + 1, false, true, limit, memo) - prices[idx];
            notBuy = limitedBuyOrSellHelper(prices, idx + 1, true, false, limit,  memo);
        }
        if (canSell){
            sell = limitedBuyOrSellHelper(prices, idx + 1, true, false, limit - 1, memo) + prices[idx];
            notSell = limitedBuyOrSellHelper(prices, idx + 1, false, true, limit,  memo);
        }
        int res = Math.max(Math.max(buy, notBuy), Math.max(sell, notSell));
        if (!canBuy && canSell){
            memo[idx][0][1][limit] = res;
            return memo[idx][0][1][limit];
        }
        else{
            memo[idx][1][0][limit] = res;
            return memo[idx][1][0][limit];
        }
    }
}
