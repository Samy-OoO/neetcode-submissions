class Solution {
    public int maxArea(int[] heights) {
        int maxA = 0, a;
        int l = 0, r = heights.length-1, left, right;
        int h, w; 

        while (l < r) {
            left = heights[l];
            right = heights[r];

            h = Math.min(left, right);
            w = r - l;
            a = h*w;
            if (a > maxA) maxA = a;
            if (left < right) l++;
            else r--;
        }

        return maxA;
    }
}
