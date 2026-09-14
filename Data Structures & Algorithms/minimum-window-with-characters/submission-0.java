class Solution {
    public String minWindow(String s, String t) {
        
        if (t.isEmpty()) return "";

        Map<Character, Integer> req = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray()){
            req.put(c, req.getOrDefault(c, 0) + 1);
        }

        int have = 0, need = req.size();
        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (req.containsKey(c) && window.get(c).equals(req.get(c))) have++;

            while (have == need) {
                if (r-l+1 < resLen) {
                    resLen = r-l+1;
                    res[0] = l;
                    res[1] = r;
                }

                char left = s.charAt(l);
                window.put(left, window.get(left) - 1);
                if (req.containsKey(left) && window.get(left) < req.get(left)) have--;
                l++;
            }
        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
