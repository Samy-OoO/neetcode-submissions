class MedianFinder {
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;
    private int size;

    public MedianFinder() {
        this.maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        this.minHeap = new PriorityQueue<>();
        this.size = 0;
    }
    
    public void addNum(int num) {
        minHeap.add(num);
        size++;
        
        if (maxHeap.size() < minHeap.size()) maxHeap.add(minHeap.poll());
        if (maxHeap.isEmpty() || minHeap.isEmpty()) return;

        if (minHeap.peek() < maxHeap.peek()) {
            int temp = minHeap.poll();
            minHeap.add(maxHeap.poll());
            maxHeap.add(temp);
        }      
    }
    
    public double findMedian() {
        double md;
        if (size % 2 == 1) md = maxHeap.peek();
        else md = (double) (maxHeap.peek() + minHeap.peek()) / 2;
        return md;
    }
}
