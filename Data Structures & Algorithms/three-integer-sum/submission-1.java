class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        int l, r;
        int left, right, fix, sum;
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        List<Integer> threeSum;

        for (int i=0; i<n; i++) {
            l = i+1;
            r = n-1;
            fix = nums[i];
            while (l<r) {
                left = nums[l];
                right = nums[r];
                sum = fix + left + right;

                if (sum == 0) {
                    threeSum = new ArrayList<>(List.of(fix, left, right));
                    if (!res.contains(threeSum)) res.add(threeSum);
                    l++;
                    r--;
                }
                else if (sum < 0) l++;
                else r--;
            }
        }

        return res;
    }
}
