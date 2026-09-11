class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        Set<Integer> window = new HashSet<>();
        int l = 0;

        for (int r=0; r < n; r++) {
            if ((r - l) > k){
                window.remove(nums[l]);
                l += 1;
            }
            if (window.contains(nums[r])) return true;
            window.add(nums[r]);
        }

        return false;
    }
}