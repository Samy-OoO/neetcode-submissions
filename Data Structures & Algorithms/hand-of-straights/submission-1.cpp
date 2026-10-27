class Solution {
public:
    bool isNStraightHand(vector<int>& hand, int groupSize) {
        if (hand.size() % groupSize != 0) return false;

        unordered_map<int, int> freqs;
        for (int val : hand) freqs[val] = freqs[val] + 1;

        priority_queue<int, vector<int>, greater<int>> minH;
        for (auto& kv : freqs) minH.push(kv.first);

        while (!minH.empty()) {
            int start = minH.top();
            for (int i = start; i < start + groupSize; i++) {
                if (freqs.find(i) == freqs.end()) return false;
                freqs[i] -= 1;
                if (freqs[i] == 0) {
                    if (i != minH.top()) return false;
                    minH.pop(); 
                }
            }
        }
        return true;
    }
};
