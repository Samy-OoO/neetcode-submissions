class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(new ArrayList<>(), nums);
        return res;
    }
    
    private void backtrack(List<Integer> cur, int[] nums) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList(cur));
            return;
        }

        for (int i=0; i < nums.length; i++) {
            if (cur.contains(nums[i])) continue;

            cur.add(nums[i]);
            backtrack(cur, nums);
            cur.removeLast();
        }
    }
}
