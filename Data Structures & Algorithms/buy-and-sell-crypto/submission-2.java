class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int l = 0;
        int profit = 0;

        for (int r=0; r < n; r++) {
            if (prices[r] < prices[l]){
                l = r;
            }
            profit = Math.max(profit, prices[r] - prices[l]); 
        }
        return profit;
    }
}
