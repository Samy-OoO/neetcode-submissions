class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0, total = 0;
        for (int i=0; i <= nums.length; i++) {
            total += i;
            if (i != nums.length) sum += nums[i];
        }
        return total - sum;
    }
}
