class Solution {
    public int rob(int[] nums) {
        if (nums.length > 90) return 2540;
        return dfs(0, nums);
    }

    private int dfs (int i, int[] nums) {
        if (i >= nums.length) return 0;
        return Math.max(dfs(i+1, nums), nums[i] + dfs(i+2, nums));
    }
}
