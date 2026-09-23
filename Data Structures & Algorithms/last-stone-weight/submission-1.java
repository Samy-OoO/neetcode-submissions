class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        while(maxHeap.size() > 1) {
            int heavy1 = maxHeap.poll();
            int heavy2 = maxHeap.poll();

            if (heavy1 != heavy2) maxHeap.offer(Math.abs(heavy1 - heavy2));
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}
