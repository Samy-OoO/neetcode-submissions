class Solution {
    int[][] dp;
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;

        dp = new int[n][sum/2 + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return dfs(nums, 0, sum/2);
    }

    private boolean dfs(int[] nums, int i,  int rem) {
        if (rem == 0) return true;
        if (i == nums.length || rem < 0) return false;
        if (dp[i][rem] != -1) return dp[i][rem] == 1;

        boolean res = dfs(nums, i+1, rem);

        if (nums[i] <= rem) {
            res = res || dfs(nums, i+1, rem - nums[i]);
        }

        dp[i][rem] = res ? 1 : 0;
        return res;
    }
}
