class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n-1, mid, num;

        while (l <= r) {
            mid = l + (r-l)/2;
            num = nums[mid];

            if (num == target) return mid;
            else if (num < target) l = mid + 1;
            else r = r - 1;
        }

        return -1;
    }
}
