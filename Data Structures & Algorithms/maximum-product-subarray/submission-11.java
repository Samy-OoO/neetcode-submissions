class Solution {
    public int maxProduct(int[] nums) {
        int globMax = Integer.MIN_VALUE;
        int curMax = 1, curMin = 1;

        for (int n : nums) {
            int tmpMax = curMax * n;
            int tmpMin = curMin * n;

            curMax = Math.max(Math.max(tmpMax, tmpMin), n);
            curMin = Math.min(Math.min(tmpMax, tmpMin), n);

            globMax = Math.max(globMax, curMax);
        }

        return globMax;
    }
}
