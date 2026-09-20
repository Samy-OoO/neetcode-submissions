class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        res = new ArrayList<>();
        backtrack(0, new LinkedList<>(), 0, candidates, target);
        return res;
    }
    private void backtrack(int i, List<Integer> cur, int total, int[] candidates, int target) {
        if (total == target) {
            res.add(new LinkedList(cur));  
            return;          
        }
        if (total > target || i >= candidates.length) return;

        cur.add(candidates[i]);
        backtrack(i+1, cur, total + candidates[i], candidates, target);
        
        cur.removeLast();

        while (i+1 < candidates.length && candidates[i+1] == candidates[i]) i++;
        backtrack(i+1, cur, total, candidates, target);
    }
}
