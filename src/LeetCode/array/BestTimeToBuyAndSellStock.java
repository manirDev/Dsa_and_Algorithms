package LeetCode.array;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int res = bestTimeToBuyAndSell(prices);
        System.out.println(res);
    }

    private static int bestTimeToBuyAndSell(int[] prices) {
        int buyingPrice = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        for (int i=0; i<prices.length - 1; i++){
            if (prices[i] < buyingPrice){
                buyingPrice = prices[i];
            }
            int sellingPrice = prices[i + 1] - buyingPrice;
            if (sellingPrice > maxProfit){
                maxProfit = sellingPrice;
            }
        }
        return Math.max(maxProfit, 0);
    }
}
