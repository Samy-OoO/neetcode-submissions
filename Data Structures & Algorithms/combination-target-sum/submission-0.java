class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        backtrack(0, new LinkedList<>(), 0, nums, target);
        return res;
    }

    private void backtrack(int i, List<Integer> cur, int total, int[] nums, int target) {
        if (total == target) {
            res.add(new LinkedList(cur));
            return;
        }
        if (i >= nums.length || total > target) return;

        cur.add(nums[i]);
        backtrack(i, cur, total + nums[i], nums, target);
        cur.removeLast();
        backtrack(i+1, cur, total, nums, target);
    }
}
