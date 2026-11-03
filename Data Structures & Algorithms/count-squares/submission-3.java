class CountSquares {
    private Map<List<Integer>, Integer> points;

    public CountSquares() {
        points = new HashMap<>();
    }
    
    public void add(int[] point) {
        List<Integer> key = Arrays.asList(point[0], point[1]);
        points.put(key, points.getOrDefault(key, 0) + 1);
    }
    
    public int count(int[] point) {
        int res = 0;
        int x1 = point[0], y1 = point[1];

        for (Map.Entry<List<Integer>, Integer> entry : points.entrySet()) {
            List<Integer> pt = entry.getKey();
            int x2 = pt.get(0), y2 = pt.get(1);

            int absX = Math.abs(x2 - x1), absY = Math.abs(y2 - y1);
            if ((absX == 0 || absY == 0) || absX != absY) continue;

            res += (entry.getValue() 
            * points.getOrDefault(Arrays.asList(x1, y2), 0) 
            * points.getOrDefault(Arrays.asList(x2, y1), 0));
        }

        return res;
    }
}
