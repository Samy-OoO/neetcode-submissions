class DSU {
public:
    int count;
    vector<int> par, rank;

    DSU (int n) {
        this->par = vector<int>(n + 1);
        this->rank = vector<int>(n + 1, 0);
        count = n;

        for (int i = 0; i < n; i++) par[i] = i;
    }

    int find (int x) {
        if (x != par[x]) {
            par[x] = find(par[x]);
        }
        return par[x];
    }

    bool unify (int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if (parA == parB) return false;
        if (rank[parA] > rank[parB]) par[parB] = parA;
        else if (rank[parB] > rank[parA]) par[parA] = parB;
        else {
            par[parB] = parA;
            rank[parA]++;
        }
        count--;

        return true;
    }
};

class Solution {
public:
    bool canTraverseAllPairs(vector<int>& nums) {
        int n = nums.size();
        DSU dsu(n);
        unordered_map<int, int> factor_index;

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int f = 2;
            while (f*f <= num) {
                if (num % f == 0) {
                    if (factor_index.count(f)) dsu.unify(i, factor_index[f]);
                    else factor_index[f] = i;

                    while (num % f == 0) num /= f;
                }
                f++;
            }
            if (num > 1) {
                if (factor_index.count(num)) dsu.unify(i, factor_index[num]);
                else factor_index[num] = i;
            }
        }

        return dsu.count == 1;
    }
};