class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;

        int[] res = new int[n];
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{temperatures[0], 0});

        for (int i=1; i<n; i++) {
            while(!stack.isEmpty() && temperatures[i] > stack.peek()[0]) {
                int index = stack.pop()[1];
                int days = i-index;
                res[index] = days;
            }
            stack.push(new int[]{temperatures[i], i});
        }

        return res;
    }
}
