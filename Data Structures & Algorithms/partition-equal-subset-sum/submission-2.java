class Solution {
    int[] dp;
    public boolean canPartition(int[] nums) {
        boolean[] vis = new boolean[nums.length];

        int sum = 0;
        for (int num : nums) sum += num;
        dp = new int[sum+1];
        Arrays.fill(dp, -1);

        return backtrack(nums, sum, 0, vis);
    }

    private boolean backtrack(int[] nums, int total, int curSum, boolean[] vis) {
        if (total - curSum == curSum) return true;
        if (dp[curSum] != -1) return (dp[curSum] == 1) ? true : false;

        boolean res = false;
        for (int i = 0; i < nums.length; i++) {
            if (vis[i]) continue;
            
            vis[i] = true;
            res = res || backtrack(nums, total, curSum + nums[i], vis);
            vis[i] = false;
        }

        dp[curSum] = (res) ? 1 : 0;
        return res;
    }
}
