class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int f = nums.length + 1;
        List<Integer>[] freq = new List[f];
        

        for (int i=0; i<f; i++) {
            freq[i] = new ArrayList<>();
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int idx = 0;
        for (int i = f-1; i>0 && idx<k; i--){
            for (int num : freq[i]){
                res[idx++] = num;
                if (idx == k) return res;
            }
        }
        
        return res;
    }
}
