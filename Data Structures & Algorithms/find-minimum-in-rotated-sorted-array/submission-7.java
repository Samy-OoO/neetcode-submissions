class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length-1;

        if (nums[l] < nums[r]) return nums[l];

        while (l < r) {
            int mid = l + (r-l)/2;
            int num = nums[mid];

            if (num > nums[r]) l = mid + 1;
            else if (num < nums[r]) r = mid;
        } 
        return nums[r];
    }
}
