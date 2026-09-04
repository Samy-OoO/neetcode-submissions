class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> hSet = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            hSet.add(num);
        }

        for (int num : hSet) {
            list.add(num);
        }

        Collections.sort(list);

        for (int i=0; i<list.size(); i++) {
            nums[i] = list.get(i);
        }

        return hSet.size();
    }
}