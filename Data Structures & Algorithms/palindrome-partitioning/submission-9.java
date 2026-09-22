class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtrack(0, 1, new ArrayList<>(), s);
        return res;
    }

    private void backtrack(int i, int j, List<String> cur, String s) {
        if (i == s.length()) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (i >= s.length() || j > s.length()) return;

        String str = s.substring(i, j);
        if (isPalin(str)) { 
            cur.add(str);
            backtrack(j, j+1, cur, s);
            cur.removeLast();
        } 
        backtrack(i, j+1, cur, s);
    }

    private boolean isPalin(String str) {
        int l = 0;
        int r = str.length() - 1;
        
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}