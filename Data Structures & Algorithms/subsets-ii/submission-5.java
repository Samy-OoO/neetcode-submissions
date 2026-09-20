class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        res = new LinkedList<>();
        backtrack(0, new LinkedList<>(), nums);
        return res;
    }

    private void backtrack(int i, List<Integer> subset, int[] nums) {
        if (i >= nums.length) {
            res.add(new LinkedList(subset));
            return;
        }

        subset.add(nums[i]);
        backtrack(i+1, subset, nums);
        subset.removeLast();

        while (i+1 < nums.length && nums[i+1] == nums[i]) i++;

        backtrack(i+1, subset, nums);
    }
}
