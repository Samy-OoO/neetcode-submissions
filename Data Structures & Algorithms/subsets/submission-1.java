class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0, new ArrayList<>());
        return res;
    }
    private void backtrack (int[] nums, int i, List<Integer> arr) {
        if (i == nums.length){
            List<Integer> copy = new ArrayList<>(arr);
            res.add(copy);
            return;
        }

        arr.add(nums[i]);
        backtrack(nums, i+1, arr);

        arr.removeLast();
        backtrack(nums, i+1, arr);
    }
}
