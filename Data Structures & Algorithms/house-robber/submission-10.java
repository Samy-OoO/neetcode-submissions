class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = 0;

        for (int i=0; i < nums.length; i++) {
            int temp = Math.max(dp[1], dp[0] + nums[i]);;
            dp[0] = dp[1];
            dp[1] = temp;
        }

        return dp[1];
    }
}
