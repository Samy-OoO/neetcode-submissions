class TrieNode {
    TrieNode[] children;
    boolean isEnd = false;
    char character;

    TrieNode (char ch){
        children = new TrieNode[26];
        this.character = ch;
    }
}

class Solution {
    private int rows, cols;
    private TrieNode root = new TrieNode('0');
    private List<String> res = new ArrayList<>();
    private Set<Pair<Integer, Integer>> path = new HashSet<>();
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<String> findWords(char[][] board, String[] words) {
        rows = board.length;
        cols = board[0].length;

        for (String word : words) insert(word);

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                backtrack(r, c, "", board, root);
            }
        }

        return res;
    }

    private void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (node.children[idx] == null) node.children[idx] = new TrieNode(ch);
            node = node.children[idx];
        }
        node.isEnd = true;
    }

    private void backtrack(int r, int c, String curWord, char[][] board, TrieNode node) {
        if ( (r < 0 || r >= rows) || 
             (c < 0 || c >= cols) ||
             path.contains(new Pair<>(r, c)) ) return;

        int curIdx = board[r][c] - 'a';
        if (node.children[curIdx] == null) return;

        curWord += board[r][c];
        node = node.children[curIdx];
        
        if (node.isEnd){
            res.add(curWord);
            node.isEnd = false;
        }

        path.add(new Pair<>(r, c));
        for (int[] dir : directions) {
            int nr = r + dir[0], nc = c + dir[1];
            backtrack(nr, nc, curWord, board, node);
        }
        path.remove(new Pair<>(r, c));
    }
}
