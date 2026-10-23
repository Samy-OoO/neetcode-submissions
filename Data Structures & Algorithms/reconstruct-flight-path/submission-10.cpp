class Solution {
public:
    vector<string> res;
    unordered_map<string, deque<string>> adj; 
    vector<string> findItinerary(vector<vector<string>>& tickets) {
        int n = tickets.size();

        for (vector<string>& ticket : tickets) {
            adj[ticket[0]].push_back(ticket[1]);
        }

        for (auto& [src, dests] : adj) {
            sort(dests.rbegin(), dests.rend());
        }

        dfs("JFK");
        reverse(res.begin(), res.end());
        return res;               
    }

private:
    void dfs(const string& src) {
        while (!adj[src].empty()) {
            string dst = adj[src].back(); adj[src].pop_back();
            dfs(dst);
        }
        res.push_back(src);
    }
};
