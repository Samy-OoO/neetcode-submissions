class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freqs = new int[26];
        for (char task : tasks) {
            freqs[task - 'A']++;
        }
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int freq : freqs) {
            if (freq != 0) maxHeap.offer(freq);
        }

        int time = 0;
        Queue<int[]> q = new LinkedList<>();
        int ongoingTaskFq, cooledTaskFq;
        while (!q.isEmpty() || !maxHeap.isEmpty()) {
            if (!maxHeap.isEmpty()) { 
                ongoingTaskFq = maxHeap.poll();
                ongoingTaskFq--;
                if (ongoingTaskFq > 0) q.offer(new int[]{time, ongoingTaskFq});
            }
            if (!q.isEmpty() && time-q.peek()[0] >= n) { 
                cooledTaskFq = q.poll()[1];
                maxHeap.offer(cooledTaskFq);
            }
            time++;
        }

        return time;
    }
}
