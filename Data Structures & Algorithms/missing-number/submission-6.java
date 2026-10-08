class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int xor = i ^ nums[i];
            if (xor != 0) return i;
        }
        return nums.length;
    }
}
