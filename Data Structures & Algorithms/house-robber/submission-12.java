class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[2];

        for (int i=0; i < nums.length; i++) {
            int max = Math.max(dp[1], dp[0] + nums[i]);;
            dp[0] = dp[1];
            dp[1] = max;
        }

        return dp[1];
    }
}
