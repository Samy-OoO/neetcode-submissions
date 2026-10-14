class Solution {
    public int maxProduct(int[] nums) {
        int globMax = Integer.MIN_VALUE, minProd = Integer.MAX_VALUE;
        int curMax = Integer.MIN_VALUE, curMin = 1;
        int prod = 1;

        for (int n : nums) {
            if (prod == 0) prod = 1;
            prod *= n;

            curMax = prod;
            if (prod < 0 && curMin < 0) curMax /= curMin;           
            globMax = Math.max(globMax, curMax);

            if (curMin > 0) curMin *= n;
            if (prod == 0) curMin = 1;
        }

        return globMax;
    }
}
