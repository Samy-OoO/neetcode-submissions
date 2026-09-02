class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hMap = new HashMap<>();
        int[] res = new int[2];

        for (int i=0; i<nums.length; i++) {
            int diff = target - nums[i];

            if(hMap.containsKey(diff)){
                res[0] = hMap.get(diff);
                res[1] = i;
            }

            hMap.put(nums[i], i);
        }
        return res;
    }
}
