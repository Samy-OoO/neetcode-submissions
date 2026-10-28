class KthLargest {
private:
    priority_queue<int, vector<int>, greater<int>> minH;
    int k;
public:
    
    KthLargest(int k, vector<int>& nums) {
        this->minH = priority_queue<int, vector<int>, greater<int>>(nums.begin(), nums.end());
        this->k = k;
    }
    
    int add(int val) {
        minH.push(val);
        while (minH.size() > k) {
            minH.pop();
        }
        return minH.top();
    }
};
