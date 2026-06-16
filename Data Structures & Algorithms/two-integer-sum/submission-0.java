class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] pair = new int[2];
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<nums.length; j++){
                if(i==j) continue;
                if((nums[i] + nums[j]) == target){
                    pair[0] = i;
                    pair[1] = j;
                    return pair;
                }
            }
        }
        return null;
    }
}
