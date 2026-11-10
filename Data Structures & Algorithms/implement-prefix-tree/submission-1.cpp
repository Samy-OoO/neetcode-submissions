class TrieNode {
public:
    TrieNode* children[26];
    bool isEnd;

    TrieNode() {
        for (int i = 0; i < 26; i++) children[i] = nullptr;
        isEnd = false;
    }
};

class PrefixTree {
private:
    TrieNode* root;

public:
    PrefixTree() {
        root = new TrieNode();
    }
    
    void insert(string word) {
        TrieNode* cur = root;
        for (char ch : word) {
            int i = ch - 'a';
            if (cur->children[i] == nullptr) cur->children[i] = new TrieNode();
            cur = cur->children[i];
        }      
        cur->isEnd = true;  
    }
    
    bool search(string word) {
        TrieNode* cur = root;
        for (char ch : word) {
            int i = ch - 'a';
            if (!cur->children[i]) return false;
            cur = cur->children[i];
        }
        return cur->isEnd;
    }
    
    bool startsWith(string prefix) {
        TrieNode* cur = root;
        for (char ch : prefix) {
            int i = ch - 'a';
            if (!cur->children[i]) return false;
            cur = cur->children[i];
        }
        return true;
    }
};
