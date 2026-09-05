class Solution {
    public int removeDuplicates(int[] nums) {
        int l=1, tol=0;
        for (int r=1; r<nums.length; r++) {
            if (nums[r] == nums[r-1]) {
                tol++;
                if (tol < 2){
                    nums[l++] = nums[r];
                }
            }else{
                nums[l++] = nums[r];
                tol=0;
            }
        }
        return l;
    }
}