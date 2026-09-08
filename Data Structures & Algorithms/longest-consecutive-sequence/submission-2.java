class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<nums.length; i++) {
            set.add(nums[i]);
        }

        int res=0;
        int c, track;
        for (int n : set) {
            if (set.contains(n-1)) continue;
            c = 1;
            track = n + 1;

            for (int m : set) {
                if (set.contains(track)) {
                    track++;
                    c++;
                }
            }
            if(c > res) res = c;
        }

        return res;
    }
}
