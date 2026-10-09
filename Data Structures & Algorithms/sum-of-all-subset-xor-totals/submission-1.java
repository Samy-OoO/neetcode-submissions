class Solution {
    int res = 0;
    public int subsetXORSum(int[] nums) {
        backtrack(0, new ArrayList<>(), nums);
        return res;
    }

    private void backtrack(int i, List<Integer> cur, int[] nums) {
        if (i == nums.length) {
            int total = 0;
            for (int n : cur) total ^= n;
            res += total;
            return;
        }

        cur.add(nums[i]);
        backtrack(i+1, cur, nums);

        cur.removeLast();
        backtrack(i+1, cur, nums);
    }
}