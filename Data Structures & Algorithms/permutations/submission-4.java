class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(0, new ArrayList<>(), nums);
        return res;
    }
    
    private void backtrack(int mask, List<Integer> cur, int[] nums) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList(cur));
            return;
        }

        for (int i=0; i < nums.length; i++) {
            if ((mask & (1 << i)) == 0){
                cur.add(nums[i]);
                backtrack(mask | (1 << i), cur, nums);
                cur.removeLast();
            }     
        }
    }
}
