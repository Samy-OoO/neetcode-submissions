class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backtrack(0, 0, new ArrayList<>(), nums, target);
        return res;
    }

    private void backtrack (int i, int sum, List<Integer> comb, int[] nums, int target) {
        if (sum == target) {
            res.add(new ArrayList<>(comb));
            return;
        } else if (sum > target) return;
        if (i >= nums.length) return;

        comb.add(nums[i]);
        backtrack(i, sum + nums[i], comb, nums, target);

        comb.removeLast();
        backtrack(i+1, sum, comb, nums, target);
    }
}
