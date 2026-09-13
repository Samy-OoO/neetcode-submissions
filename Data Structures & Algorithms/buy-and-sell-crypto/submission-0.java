class Solution {
    public int maxProfit(int[] prices) {
        int max = 0, profit = 0;
        int l = 0;
        
        for (int r = 1; r<prices.length; r++) {
            profit = prices[r] - prices[l];
            if (prices[r] < prices[l]) {
                l = r;
                profit = 0;
            }
            if (profit > max) max = profit;
        }

        return max;
    }
}
