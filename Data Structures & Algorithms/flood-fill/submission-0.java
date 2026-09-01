class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int orig = image[sr][sc];
        if (orig == color) return image;
        int m = image.length, n= image[0].length;
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sr, sc});
        image[sr][sc] = color;
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        while (!q.isEmpty()) {
            int[] cell = q.remove();
            int r = cell[0], c = cell[1];
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == orig){
                    image[nr][nc] = color;
                    q.add(new int[]{nr, nc});
                }
            }
        }
        return image;
    }
}