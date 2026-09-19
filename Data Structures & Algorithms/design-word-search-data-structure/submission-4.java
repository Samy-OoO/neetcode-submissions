class TrieNode {
    TrieNode[] children = new TrieNode[26];
    char character;
    TrieNode(char character) {
        this.character = character;
    }
    boolean endOfWord = false;
}

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode('0');
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (cur.children[i] == null) cur.children[i] = new TrieNode(c);
            cur = cur.children[i];
        }
        cur.endOfWord = true;
    }

    public boolean search(String word) {
        return dfs(root, word);
    }

    private boolean dfs(TrieNode node, String word) {
        TrieNode cur = node;
        int index = 0;
        for (char c : word.toCharArray()) {
            if (c == '.') {
                String partWord = word.substring(index+1, word.length());
                for (int i=0; i<26; i++) {
                    if (cur.children[i] != null && dfs(cur.children[i], partWord)) {
                        return true;
                    }
                }
                return false;
            }
            int i = c - 'a';
            if (cur.children[i] == null) return false;
            cur = cur.children[i];
            index++;
        }
        return cur.endOfWord;
    }
}
