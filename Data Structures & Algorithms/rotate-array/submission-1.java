class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return;
        int count = 0;
        k %= n;

        for (int l = 0; l < n; l++) {
            int i = l;
            int temp = nums[l];

            while(true) {
                int j = (n+i-k) % n;
                if (j == l) break;
                nums[i] = nums[j];
                count++;
                i = j;
            }

            nums[i] = temp;
            if (++count == n) break;
        }
    }
}