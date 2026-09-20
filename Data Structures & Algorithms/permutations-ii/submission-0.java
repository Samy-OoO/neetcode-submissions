class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(new ArrayList<>(), new boolean[nums.length], nums);
        return res;
    }

    private void backtrack(List<Integer> perm, boolean[] visited, int[] nums) {
        if (perm.size() == nums.length) {
            res.add(new ArrayList<>(perm));
            return;
        }
        for (int i=0; i<nums.length; i++) {
            if (visited[i]) continue;

            perm.add(nums[i]);
            visited[i] = true;
            backtrack(perm, visited, nums);

            perm.removeLast();
            visited[i] = false;
            while(i+1 < nums.length && nums[i+1] == nums[i]) i++;
        }
    }
}