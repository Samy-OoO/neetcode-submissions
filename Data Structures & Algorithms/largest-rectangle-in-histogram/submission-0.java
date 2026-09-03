class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxA=0, a, index, n=heights.length;
        int[] popd;
        Stack<int[]> stack = new Stack<>();

        for (int i=0; i<n; i++) {
            index = i;
            while (!stack.isEmpty() && heights[i] < stack.peek()[1]) {
                popd = stack.pop();
                a = popd[1] * (i - popd[0]);
                if (a > maxA) maxA = a;
                index = popd[0];
            }
            stack.push(new int[]{index, heights[i]});
        }

        while (!stack.isEmpty()) {
            popd = stack.pop();
            a = popd[1] * (n - popd[0]);
            if (a > maxA) maxA = a;
        }

        return maxA;
    }
}
