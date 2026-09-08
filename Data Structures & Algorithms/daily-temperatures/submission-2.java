class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<int[]> stack = new Stack<>();

        int cur, days, idx;
        for (int i=0; i<n; i++) {
            cur = temperatures[i];

            while (!stack.isEmpty() && cur > stack.peek()[0]) {
                idx = stack.pop()[1];
                days = i - idx;
                res[idx] = days;
            }

            stack.push(new int[]{cur, i});
        }        

        return res;
    }
}
