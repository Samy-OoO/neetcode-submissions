class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int curH, idx;
        int maxA=0, a, w, h;
        
        for (int i=0; i < heights.length; i++) {
            curH = heights[i];
            idx = i;
            while (!stack.isEmpty() && stack.peek()[1] > curH) {
                int[] popd = stack.pop();
                idx = popd[0];
                a = (i-idx) * popd[1];
                if (a > maxA) maxA = a;
            }

            stack.push(new int[]{idx,curH});
        }

        while (!stack.isEmpty()) {
            int[] popd = stack.pop();
            idx = popd[0];
            a = (heights.length-idx) * popd[1];
            if (a > maxA) maxA = a;
        }

        return maxA;
    }
}
