class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n-1;
        int mid, num;
        int pivot;

        if (nums[0] >= nums[r]) {
            while (l < r) {
                mid = l + (r-l)/2;
                num = nums[mid];

                if (num > nums[r]) l = mid + 1;
                else r = mid;
            }
            pivot = r;
        } else pivot = 0;

        

        if (pivot == 0) return binarySearch(nums, target, 0, n-1);
        
        int res = binarySearch(nums, target, 0, pivot-1);

        if (res != -1) return res;

        res = binarySearch(nums, target, pivot, n-1);

        return res;

    }

    private int binarySearch(int[] nums, int target, int l, int r) {
        int mid, num;

        while (l <= r) {
            mid = l + (r-l)/2;
            num = nums[mid];

            if (num == target) return mid;
            else if (num < target) l = mid + 1;
            else r = mid - 1;
        }

        return -1;
    }
}
