class Solution {
public:
    string predictPartyVictory(string senate) {
        queue<int> D, R;
        int n = senate.size();

        for (int i = 0; i < n; i++) {
            char c = senate[i];
            if (c == 'R') R.push(i);
            else D.push(i);
        }

        while (!D.empty() && !R.empty()) {
            int dTurn = D.front(); D.pop();
            int rTurn = R.front(); R.pop();

            if (rTurn < dTurn) R.push(dTurn + n);
            else D.push(rTurn + n);
        }

        return D.empty() ? "Radiant" : "Dire";

    }
};