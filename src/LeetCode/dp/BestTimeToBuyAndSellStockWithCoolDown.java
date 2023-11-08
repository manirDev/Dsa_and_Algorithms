package LeetCode.dp;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockWithCoolDown {
    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        int[][][] memo = new int[prices.length][2][2];
        for (int dd[][] : memo){
            for (int[] d : dd){
                Arrays.fill(d, -1);
            }
        }
        int res = buySellCoolDownHelper(prices, 0, true, false, memo);
        System.out.println(res);
    }

    private static int buySellCoolDownHelper(int[] prices, int idx, boolean canBuy, boolean canSell, int[][][] memo) {
        if (idx >= prices.length){
            return 0;
        }
        int buy = 0;
        int notBuy = 0;
        int sell = 0;
        int notSell = 0;

        if (canBuy && !canSell && memo[idx][1][0] != -1){
            return  memo[idx][1][0];
        }
        if (!canBuy && canSell && memo[idx][0][1] != -1){
            return  memo[idx][0][1];
        }
        if (canBuy){
            buy = buySellCoolDownHelper(prices, idx + 1, false, true, memo) - prices[idx];
            notBuy = buySellCoolDownHelper(prices, idx + 1, true, false, memo);
        }
        if (canSell){
            sell = buySellCoolDownHelper(prices, idx + 2, true  , false, memo) + prices[idx];
            notSell = buySellCoolDownHelper(prices, idx + 1, false, true, memo);
        }
        int res = Math.max(Math.max(buy, notBuy), Math.max(sell, notSell));
        if (canBuy && !canSell){
            memo[idx][1][0] = res;
            return  memo[idx][1][0];
        }
        else {
            memo[idx][0][1] = res;
            return memo[idx][0][1];
        }
    }
}
