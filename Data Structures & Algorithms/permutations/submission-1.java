class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(0, new ArrayList<>(), nums);
        return res;
    }
    
    private void backtrack(int n, List<Integer> cur, int[] nums) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList(cur));
            return;
        }

        for (int i=0; i < nums.length; i++) {
            if (cur.contains(nums[i])) continue;

            cur.add(nums[i]);
            backtrack(i, cur, nums);

            cur.removeLast();
        }
    }
}
