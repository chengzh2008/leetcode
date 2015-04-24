package src.main.java;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete as many transactions as
 you like (ie, buy one and sell one share of the stock multiple times). However, you may not
 engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class BestTimeBuySellStockII {
    // dynamic programming...
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (prices == null || n <= 1) return 0;
        int[] profit = new int[n];
        int maxProfit;
        int tempProfit;
        for(int i = 1; i < n; i++) {
            // if current price is not higher than previous price, skip it.
            if (prices[i] <= prices[i-1]) {
                profit[i] = profit[i-1];
                continue;
            }
            maxProfit = profit[i-1];
            for(int j = 0; j < i; j++) {
                tempProfit = profit[j] + (prices[i] - prices[j]);
                if (tempProfit > maxProfit) {
                    maxProfit = tempProfit;
                }
            }
            profit[i] = maxProfit;
        }
        return profit[n-1];
    }

    public static void main(String[] args) {
        BestTimeBuySellStockII bestTimeBuySellStockII = new BestTimeBuySellStockII();

        int[] prices = {2, 1, 4};
        System.out.println(bestTimeBuySellStockII.maxProfit(prices));
    }
}
