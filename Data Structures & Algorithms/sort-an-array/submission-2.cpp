class Solution {
private:
    void merge(vector<int>& left, vector<int>& right, vector<int>& arr) {
        int lSize = left.size(), rSize = right.size();
        int l = 0, r = 0, i = 0;

        while (l < lSize && r < rSize) {
            if (left[l] <= right[r]) arr[i] = left[l++];
            else arr[i] = right[r++];
            i++;
        }

        while(l < lSize) arr[i++] = left[l++];
        while(r < rSize) arr[i++] = right[r++];
    }

    void mergeSort(vector<int>& arr) {
        int n = arr.size();
        if (n <= 1) return;

        int mid = n / 2;
        vector<int> leftArr, rightArr;

        for (int i = 0; i < n; i++) {
            if (i < mid) leftArr.push_back(arr[i]);
            else rightArr.push_back(arr[i]);
        }

        mergeSort(leftArr);
        mergeSort(rightArr);
        merge(leftArr, rightArr, arr);
    }

public:
    vector<int> sortArray(vector<int>& nums) {
        mergeSort(nums);
        return nums;
    }
};