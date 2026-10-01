class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;

        Set<String> visit = new HashSet<>();
        Queue<String> q = new ArrayDeque<>();
        int len = beginWord.length();

        q.offer(beginWord);
        visit.add(beginWord);
        int transformations = 0;

        while (!q.isEmpty()) {
            transformations++;
            for (int i = q.size()-1; i >= 0; i--) {
                String word = q.poll();
                if (word.equals(endWord)) return transformations;
                for (String nei : children(word, wordList)) {
                    if (!visit.contains(nei)) {
                        q.offer(nei);
                        visit.add(nei);
                    }
                }
            }
        }

        return 0;
    }

    private List<String> children (String word, List<String> wordList) {
        List<String> res = new ArrayList<>();
        String s;

        for (int i=0; i < word.length(); i++) {
            char[] chArr = word.toCharArray();
            for (int j=0; j < 26; j++) {
                chArr[i] = (char) (j + 'a');
                s = new String(chArr);
                if (wordList.contains(s)) res.add(s);
            }
        }

        return res;
    }
}
