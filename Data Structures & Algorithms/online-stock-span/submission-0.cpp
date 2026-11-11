class StockSpanner {
private:
    stack<pair<int, int>> stac;

public:
    StockSpanner() {}
    
    int next(int price) {
        if (stac.empty() || stac.top().first > price) stac.push({price, 1});
        else {
            int count = 1;
            while (!stac.empty() && stac.top().first <= price) {
                count += stac.top().second;
                stac.pop();
            }
            stac.push({price, count});            
        }
        return stac.top().second;
    }
};

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner* obj = new StockSpanner();
 * int param_1 = obj->next(price);
 */