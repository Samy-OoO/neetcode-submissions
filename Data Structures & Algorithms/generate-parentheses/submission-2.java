class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        String[] pair = {"(", ")"};
        backtrack(0, 0, new StringBuilder(), n, pair);
        return res;        
    }

    private void backtrack(int open, int close, StringBuilder str, int n, String[] pair) {
        if (open == n && close == n) {
            res.add(str.toString());
            return;
        }
        
        if (open < n) {
            str.append(pair[0]);
            backtrack(open + 1, close, str, n, pair);
            str.deleteCharAt(str.length()-1);
        }

        if (close < open){
            str.append(pair[1]);
            backtrack(open, close + 1, str, n, pair);
            str.deleteCharAt(str.length()-1);
        }
    }
}
