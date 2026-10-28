class MedianFinder {
private:
    priority_queue<int> maxH;
    priority_queue<int, vector<int>, greater<int>> minH;
    int count;
public:
    MedianFinder() {
        this->count = 0;
    }
    
    void addNum(int num) {
        minH.push(num);
        count++;

        if (maxH.size() < minH.size()){
            maxH.push(minH.top());
            minH.pop();
        }
        if (maxH.empty() || minH.empty()) return;

        if (minH.top() < maxH.top()) {
            int tmp = minH.top(); minH.pop();
            minH.push(maxH.top()); maxH.pop();
            maxH.push(tmp);
        }
    }
    
    double findMedian() {
        double md;
        if (count % 2 == 1) md = maxH.top();
        else md = (static_cast<double>(maxH.top()) + minH.top()) / 2;
        return md;
    }
};
