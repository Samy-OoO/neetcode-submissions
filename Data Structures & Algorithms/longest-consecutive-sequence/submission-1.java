class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);            
        }
        
        int longest = 0;
        for (int n : set){
            if (set.contains(n-1)) continue;
            int count = 1;
            int track = n + 1;
            for (int m : set){
                if (set.contains(track)) {
                    track++;
                    count++;
                }
            }
            if (count > longest) longest = count;
        }

        return longest;
    }
}
