class Solution {
    public int openLock(String[] deadends, String target) {
        String start = "0000";

        Set<String> set = new HashSet<>();
        for (String deadend : deadends) {
            set.add(deadend);
            if (deadend.equals(start)) return -1;
        }

        Queue<String> q = new ArrayDeque<>();
        q.offer(start);
        set.add(start);
        int moves = 0;

        while (!q.isEmpty()) {
            for (int i=q.size()-1; i >= 0; i--) {
                String node = q.poll();
                if (node.equals(target)) return moves;
                for (String str : children(node)) {
                    if (!set.contains(str)) {
                        set.add(str);
                        q.offer(str);
                    }
                }
            }
            moves++;
        }
        return -1;
    }


    private List<String> children(String node) {
        List<String> res = new ArrayList<>();
        for (int i=0; i < 4; i++) {
            char[] chArray = node.toCharArray();
            int digit = chArray[i] - '0';

            chArray[i] = (char) (((digit+1) % 10) + '0');
            res.add(new String(chArray));

            chArray[i] = (char) (((digit-1+10) % 10) + '0');
            res.add(new String(chArray));
        }
        return res;
    }
}