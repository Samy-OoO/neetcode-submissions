class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l=0, r=n-1;
        int mid = n/2;
        int res;
        
        if (nums[0] > nums[r]){
            while (l < r) {
                mid = l + (r-l)/2;
                int num = nums[mid];
                
                if (num == target) res = mid;
                if (num <= nums[r]) r = mid;
                else l = mid + 1;
            }
            l = r;
        }

        if (l == 0) return binarySearch(nums, 0, n-1, target);
        
        res = binarySearch(nums, r, n-1, target);
        if (res == -1) res = binarySearch(nums, 0, r-1, target);        

        return res;
                
    }

    private int binarySearch(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int mid = l + (r-l)/2;
            int num = nums[mid];

            if (num == target) return mid;
            else if (num < target) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }
}
