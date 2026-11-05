class Solution {
private:
    int partition(vector<int>& nums, int start, int end) {
        int pivot = nums[end];
        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (nums[j] < pivot) swap(nums[++i], nums[j]);
        }
        swap(nums[++i], nums[end]);

        return i;
    }

    void quickSort(vector<int>& nums, int start, int end) {
        if (end <= start) return;

        int pivot = partition(nums, start, end);
        quickSort(nums, start, pivot - 1);
        quickSort(nums, pivot + 1, end);
    }
public:
    vector<int> sortArray(vector<int>& nums) {
        quickSort(nums, 0, nums.size() - 1);
        return nums;
    }
};