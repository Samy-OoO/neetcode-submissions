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
            List<Integer> copy = new LinkedList(subset);
            if (!res.contains(copy)) res.add(copy);
            return;
        }

        subset.add(nums[i]);
        backtrack(i+1, subset, nums);

        subset.removeLast();
        backtrack(i+1, subset, nums);
    }
}
