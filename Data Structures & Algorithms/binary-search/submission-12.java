class Solution {
    public int search(int[] nums, int target) {
        int l=0, r=nums.length-1;
        int num, mid;

        while (l<=r) {
            mid = l + (r-l)/2;
            num = nums[mid];

            if (num == target) return mid;
            else if (num < target) l = mid+1;
            else r = mid-1;
        }

        return -1;
    }
}
