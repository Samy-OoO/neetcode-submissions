class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0; i < numCourses; i++) {
            adj.add(new LinkedList<>());
        } 

        for (int[] pre : prerequisites) {
            adj.get(pre[0]).add(pre[1]);
            indegree[pre[1]]++;
        }


        Queue<Integer> q = new ArrayDeque<>();
        for (int i=0; i < numCourses; i++) {
            if (indegree[i] == 0) q.offer(i);
        }

        Stack<Integer> stack = new Stack<>();
        int finish = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            stack.push(node);
            finish++;
            for (int nei : adj.get(node)) {
                indegree[nei]--;
                if (indegree[nei] == 0) q.offer(nei);
            }
        }

        if (finish != numCourses) return new int[0];

        int[] res = new int[numCourses];
        for (int i=0; i < numCourses; i++) {
            res[i] = stack.pop();
        }

        return res;
    }
}
