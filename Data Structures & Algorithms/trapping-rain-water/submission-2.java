class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length-1;
        int maxL = l, maxR = r;
        int area = 0, a;

        while (l < r) {

            if (height[l] <= height[r]) {
                l++;
                a = (height[maxL] - height[l]);
                if (a > 0) area += a;
            } else {
                r--;
                a = (height[maxR] - height[r]);
                if (a > 0) area += a;
            }

            if (height[l] > height[maxL]) maxL = l;
            if (height[r] > height[maxR]) maxR = r;

        }

        return area;
    }
}
