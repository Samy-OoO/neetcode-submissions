class MyHashMap {
private:
    struct ListNode {
        int key, val;
        ListNode* next;

        ListNode(int key = -1, int val = -1, ListNode* next = nullptr) : key(key), val(val), next(next) {}
    };

    vector<ListNode*> nodeMap;
    int hash(int key) {
        return key % nodeMap.size();
    }


public:
    MyHashMap() {
        nodeMap.resize(1000);
        for (auto& bucket : nodeMap) {
            bucket = new ListNode(0);
        }
    }
    
    void put(int key, int value) {
        ListNode* cur = nodeMap[hash(key)];
        while (cur->next) {
            if (cur->next->key == key) {
                cur->next->val = value;
                return;
            }
            cur = cur->next;
        }
        cur->next = new ListNode(key, value);
    }
    
    int get(int key) {
        ListNode* cur = nodeMap[hash(key)]->next;
        while (cur) {
            if (cur->key == key) {
                return cur->val;
            }
            cur = cur->next;
        }      
        return -1;
    }
    
    void remove(int key) {
        ListNode* cur = nodeMap[hash(key)];
        while (cur->next) {
            if (cur->next->key == key) {
                ListNode* temp = cur->next;
                cur->next = cur->next->next;
                delete temp;
                return;
            }
            cur = cur->next;
        }
    }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */