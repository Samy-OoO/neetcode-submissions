class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        unordered_map<char, int> freqs;
        for (char& task : tasks) freqs[task] = freqs[task] + 1;

        priority_queue<int> maxH;
        for (auto& p : freqs) maxH.push(p.second);

        queue<pair<int, int>> cooldown;
        int time = 0;
        while (!maxH.empty() || !cooldown.empty()) {
            if (!maxH.empty()) {
                int freq = maxH.top(); maxH.pop();
                freq--;
                if (freq > 0) cooldown.push({freq, time});
            }

            if (!cooldown.empty()){
                pair<int, int> task = cooldown.front();
                if (time - task.second >= n) {
                    cooldown.pop();
                    maxH.push(task.first);
                }
            }
            time++;
        }
        return time;
    }
};
