class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] len = new int[n];
        Arrays.fill(len, 1);

        int lis = 1;

        for (int i=1; i < n; i++) {
            int j = i-1;
            while (j >= 0){
                if (nums[j] < nums[i]) len[i] = Math.max(len[j] + 1, len[i]);
                j--;
            }
            lis = Math.max(lis, len[i]);
        }

        return lis;
    }
}
