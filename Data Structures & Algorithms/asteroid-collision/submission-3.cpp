class Solution {
private:
    stack<int> stac;
    void collide(int ast) {
        while (!stac.empty() && stac.top() > 0 && stac.top() < abs(ast)) stac.pop();
        if (!stac.empty() && stac.top() > 0) {
            if (stac.top() == abs(ast)) stac.pop();
            return;
        }
        stac.push(ast);        
    }

public:
    vector<int> asteroidCollision(vector<int>& asteroids) {
        for (int ast : asteroids) {
            if (!stac.empty() && (stac.top() > 0 && ast < 0)) {
                collide(ast);
            } else stac.push(ast);
        }

        vector<int> res;
        while (!stac.empty()) {
            res.insert(res.begin(), stac.top());
            stac.pop();
        }
        return res;
    }
};