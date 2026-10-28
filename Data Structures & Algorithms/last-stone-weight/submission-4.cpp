class Solution {
public:
    int lastStoneWeight(vector<int>& stones) {
        priority_queue<int> maxH(stones.begin(), stones.end());

        while(maxH.size() > 1) {
            int x = maxH.top(); maxH.pop();
            int y = maxH.top(); maxH.pop();

            if (x != y) maxH.push(abs(x-y)); 
        }

        return maxH.empty() ? 0 : maxH.top();
    }
};
