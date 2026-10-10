class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        
        int n = nums.length;
        int[] copy1 = Arrays.copyOfRange(nums, 0, n-1);
        int[] copy2 = Arrays.copyOfRange(nums, 1, n);

        return Math.max(findMax(copy1), findMax(copy2));        
    }

    private int findMax(int[] nums) {
        int[] dp = new int[2];
        for (int i=0; i < nums.length; i++) {
            int max = Math.max(dp[1], dp[0] + nums[i]);
            dp[0] = dp[1];
            dp[1] = max;
        }

        return dp[1];
    }
}
