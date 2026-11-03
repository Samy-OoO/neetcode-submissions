class CountSquares {
    private Map<String, Integer> points;

    public CountSquares() {
        points = new HashMap<>();
    }
    
    public void add(int[] point) {
        int x = point[0], y = point[1];
        String key = point[0] + ", " + point[1];
        points.put(key, points.getOrDefault(key, 0) + 1);
    }
    
    public int count(int[] point) {
        int res = 0;
        int x1 = point[0], y1 = point[1];

        for (Map.Entry<String, Integer> entry : points.entrySet()) {
            String[] pt = entry.getKey().split(", ");
            int x2 = Integer.parseInt(pt[0]), y2 = Integer.parseInt(pt[1]);

            int absX = Math.abs(x2 - x1), absY = Math.abs(y2 - y1);
            if ((absX == 0 || absY == 0) || absX != absY) continue;

            String pt1 = x1 + ", " + y2;
            String pt2 = x2 + ", " + y1;
            res += (entry.getValue() * points.getOrDefault(pt1, 0) * points.getOrDefault(pt2, 0));
        }

        return res;
    }
}
