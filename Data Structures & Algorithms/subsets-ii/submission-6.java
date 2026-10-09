class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(0, new ArrayList<>(), nums);
        return res;
    }

    private void backtrack(int i, List<Integer> cur, int[] nums) {
        if (i == nums.length) {
            res.add(new ArrayList(cur));
            return;
        }

        cur.add(nums[i]);
        backtrack(i+1, cur, nums);

        cur.removeLast();
        while (i+1 < nums.length && nums[i] == nums[i+1]) i++;
        backtrack(i+1, cur, nums);
    }
}
