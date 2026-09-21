class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        int nums[] = new int[n];
        for (int i=0; i<n; i++) {
            nums[i] = i+1;
        }

        backtrack(0, nums, new ArrayList<>(), k);
        return res;
    }

    private void backtrack(int i, int[] nums, List<Integer> cur, int k) {
        if (cur.size() == k) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (i >= nums.length) return;

        cur.add(nums[i]);
        backtrack(i+1, nums, cur, k);

        cur.removeLast();
        backtrack(i+1, nums, cur, k);
    }
}