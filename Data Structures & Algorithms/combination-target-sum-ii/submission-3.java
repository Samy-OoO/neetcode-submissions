class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(0, 0, new ArrayList<>(), candidates, target);
        return res;
    }

    private void backtrack(int i, int sum, List<Integer> cur, int[] candidates, int target){
        if (sum == target) {
            res.add(new ArrayList<>(cur));
            return;
        } else if (sum > target) return;

        if (i >= candidates.length) return;

        cur.add(candidates[i]);
        backtrack(i+1, sum + candidates[i], cur, candidates, target);

        cur.removeLast();

        while (i+1 < candidates.length && candidates[i] == candidates[i+1]) i++;
        backtrack(i+1, sum, cur, candidates, target);
    }
}
