class Solution {
public:
    int networkDelayTime(vector<vector<int>>& times, int n, int k) {
        
        vector<vector<pair<int, int>>> adj(n+1);
        for (vector<int>& time : times) {
            adj[time[0]].push_back({time[2], time[1]});
        }


        unordered_set<int> vis;
        int res = 0;

        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>> > minHeap;
        minHeap.push({0, k});

        while (!minHeap.empty()) {
            auto[w1, node] = minHeap.top(); 
            minHeap.pop();
            
            if (vis.contains(node)) continue;
            vis.insert(node);
            res = max(res, w1);

            for (auto [w2, n2] : adj[node]) {
                if (!vis.contains(n2)) minHeap.push({w1+w2, n2});
            }
        }

        return vis.size() == n ? res : -1; 

    }
};
