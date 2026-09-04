class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length-1;
        int left, right, diff;

        while (l < r) {
            left = numbers[l];
            right = numbers[r];
            diff = target - left;

            if (diff == right) return new int[]{l+1, r+1};
            else if (diff < right) r--;
            else {
                r = numbers.length-1;
                l++;
            }

        }

        return new int[]{};
    }
}
