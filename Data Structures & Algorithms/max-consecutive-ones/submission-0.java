class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ones = 0, max = 0;
        for(int num: nums){
            if(num==1) ones++;
            else ones = 0;
            if(ones>max) max = ones;
        }
        return max;
    }
}