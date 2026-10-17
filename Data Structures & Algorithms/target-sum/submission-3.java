class Solution {
    int[][] memo;
    int sum = 0;
    public int findTargetSumWays(int[] nums, int target) {
        for (int n : nums) sum += n;
        memo = new int[nums.length + 1][2*sum + 1];
        return dfs(0, 0, nums, target);
    }

    private int dfs(int i, int acc, int[] nums, int target) {
        if (i >= nums.length) return (acc == target) ? 1 : 0;
        if (memo[i][sum + acc] != 0) return memo[i][sum + acc];

        return memo[i][sum + acc] = dfs(i+1, acc-nums[i], nums, target) + dfs(i+1, acc+nums[i], nums, target);
    }
}
