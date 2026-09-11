class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length-1;
        int maxL = height[l], maxR = height[r];
        int area = 0, a;

        while (l < r) {

            if (height[l] <= height[r]) {
                l++;
                a = (maxL - height[l]);
                if (a > 0) area += a;
            } else {
                r--;
                a = (maxR - height[r]);
                if (a > 0) area += a;
            }

            if (height[l] > maxL) maxL = height[l];
            if (height[r] > maxR) maxR = height[r];

        }

        return area;
    }
}
