class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length-1;
        int mid, num, right, res=0;

        if (nums[l] < nums[r]) return nums[0];
        
        while (l <= r) {
            mid = l + (r-l)/2;
            num = nums[mid];
            right = nums[r];

            if (num >= right) l = mid + 1;
            else if (num < right) r = mid;
        }

        return nums[r];
    }
}
