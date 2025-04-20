package com.decodejava.dsa.arrays;

public class BuyAndSellStocks {
    public int maxProfit(int[] prices) {
//        return bruteForce(prices);
        return optimalApproach(prices);
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    private static int optimalApproach(int[] prices) {

        /**
         * At any selling point if there exists some profit then condition is :
         *
         *                  there is profit = at any selling point - min of all prices to left
         *
         *     - So, we keep track of min until current ele.
         *     - If current element is not min then we try to obtain profit
         *
         *
         */
        int buy = 0, maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[buy]) buy = i;
            else {
                int compute = prices[i] - prices[buy];
                if (compute > 0 && maxProfit < compute) maxProfit = compute;
            }
        }
        return maxProfit;
    }

    private static int bruteForce(int[] prices) {
        //brute: select every element as buy and try to sell it from next day to
        //      CHECK THE MAX profit. (n^2)
        int maxProfit = 0;
        for(int i = 0; i< prices.length; i++) {
            for(int j = i+1; j< prices.length; j++) {
                int transaction = prices[j]- prices[i];
                if(transaction > 0) {
                    if(transaction > maxProfit) maxProfit = transaction;
                }
            }
        }
        return maxProfit;
    }
}
