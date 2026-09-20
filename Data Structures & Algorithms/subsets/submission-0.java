class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        backtrack(0, new LinkedList<>(), nums);
        return res;
    }

    private void backtrack(int i, List<Integer> set, int[] nums) {
        if (i >= nums.length) {
            res.add(new LinkedList(set));
            return;
        }

        set.add(nums[i]); // Choose
        backtrack(i+1, set, nums);

        set.removeLast(); // Remove
        backtrack(i+1, set, nums);
    }
}
