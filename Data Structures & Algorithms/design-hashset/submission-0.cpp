class MyHashSet {
private:
    vector<int> hSet;
    int count;
public:
    MyHashSet() {
        count = 0;
    }
    
    void add(int key) {
        if (find(hSet.begin(), hSet.end(), key) != hSet.end()) return;
        hSet.push_back(key);
        count++;
    }
    
    void remove(int key) {
        erase(hSet, key);
    }
    
    bool contains(int key) {
        if (find(hSet.begin(), hSet.end(), key) != hSet.end()) return true;
        return false;
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */