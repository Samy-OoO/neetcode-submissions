class TrieNode {
    TrieNode[] children;
    boolean isEnd;
    char character;

    TrieNode (char character) {
        children = new TrieNode[26];
        this.character = character;
    }
}

class Solution {
    TrieNode root;
    int rows, cols;
    List<String> res = new ArrayList<>();
    Set<Pair<Integer, Integer>> path = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {
        rows = board.length;
        cols = board[0].length;
        root = new TrieNode('0');

        for (String word : words) {
            addToTrie(word);
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                backtrack(r, c, root, "", board);
            }
        }
        return res;
    }

    private void addToTrie(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (cur.children[idx] == null) cur.children[idx] = new TrieNode(c);
            cur = cur.children[idx];
        }
        cur.isEnd = true;
    }

    private void backtrack(int r, int c, TrieNode node, String word, char[][] board) {
        if (r < 0 || r >= rows || c < 0 || c >= cols || 
            path.contains(new Pair(r, c))) { 
                return;
        }

        int idx = board[r][c] - 'a';
        if (node.children[idx] == null) return;
        node = node.children[idx];

        path.add(new Pair(r, c));
        word += board[r][c];
        if (node.isEnd) { 
            res.add(word);
            node.isEnd = false;
        }

        backtrack(r+1, c, node, word, board);
        backtrack(r-1, c, node, word, board);
        backtrack(r, c+1, node, word, board);
        backtrack(r, c-1, node, word, board);

        path.remove(new Pair(r, c));
    }
}
