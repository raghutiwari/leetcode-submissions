class Solution {
    public int maxProfit(int[] prices) {
        // Initially not doing anything is our best profit, hence = 0;
        int maxProfit = 0;
        // Lets assume the minimum price at which we can buy the stock to have 
        // Maximum profit is the 0th day.
        int minBuy = prices[0];

        // Iterate through the 1st day to the Nth day (n is the number of elements in prices)
        for (int i = 1; i < prices.length; i++) {
            // We will calculate the profit if we sell on this day
            int profit = prices[i] - minBuy;
            // We will check if this could be our Minimum buy if it is less than
            // already computed minBuy
            minBuy = Math.min(minBuy, prices[i]);

            // We will check if the profit is maxProfit we could have achieved.
            maxProfit = Math.max(maxProfit, profit);
            
        }

        // Return the maximum profit
        return maxProfit;
    }
}