class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> threeNums;
        int n = nums.length;
        int l, r, sum;
        int left, right, fixed;

        for (int i=0; i<n; i++){
            l = i+1;
            r= nums.length-1;
            fixed = nums[i];
            if (fixed > 0) break;

            while (l < r) {
                left = nums[l];
                right = nums[r];
                sum = left + right + fixed;

                if (sum == 0) {
                    threeNums = new ArrayList<>(List.of(left, fixed, right));
                    if (!res.contains(threeNums)) res.add(threeNums);
                    l++;
                    r--;
                }

                else if(sum < 0) l++;
                
                else r--;
            }

        }
        
        return res;
    }
}
