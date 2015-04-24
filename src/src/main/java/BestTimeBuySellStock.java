package src.main.java;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.
 */
public class BestTimeBuySellStock {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (prices == null || n <= 1) {
            return 0;
        }
        int[] profit = new int[n];
        int[] lowestPriceSoFar = new int[n];
        lowestPriceSoFar[0] = prices[0];
        // current max profit is the maximum of previous max and the current price - lowest price so far
        for (int i = 1; i < n; i++) {
            profit[i] = Math.max(profit[i - 1], prices[i] - lowestPriceSoFar[i - 1]);
            lowestPriceSoFar[i] = Math.min(lowestPriceSoFar[i - 1], prices[i]);
        }
        return profit[n - 1];
    }

    public int maxProfitO1space(int[] prices) {
        int max = 0;
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit += prices[i] - prices[i-1];
            if (profit <=0) profit = 0;
            if (profit > max) max = profit;
        }
        return max;
    }
}
