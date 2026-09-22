class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int curSum = 0;

        for (int n : nums) {
            curSum = Math.max(curSum, 0) + n;
            max = Math.max(max, curSum);
        }
        return max;
    }
}
