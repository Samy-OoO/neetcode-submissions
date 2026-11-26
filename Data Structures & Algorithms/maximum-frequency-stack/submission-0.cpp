class FreqStack {
public:
    unordered_map<int, int> cnt;
    vector<stack<int>> stacks;

    FreqStack() {
        stacks.push_back(stack<int>());
    }
    
    void push(int val) {
        int valCnt = ++cnt[val];
        if (valCnt == stacks.size()) stacks.push_back(stack<int>());
        stacks[valCnt].push(val);
    }
    
    int pop() {
        stack<int>& topStack = stacks.back();
        int res = topStack.top(); topStack.pop();
        if (topStack.empty()) stacks.pop_back();
        cnt[res]--;
        return res;
    }
};

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack* obj = new FreqStack();
 * obj->push(val);
 * int param_2 = obj->pop();
 */