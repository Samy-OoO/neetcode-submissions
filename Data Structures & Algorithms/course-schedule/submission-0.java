class Solution {
    Map<Integer, List<Integer>> preMap = new HashMap<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        for (int i = 0; i < numCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }

        for (int[] prereq : prerequisites) {
            preMap.get(prereq[0]).add(prereq[1]);
        }

        boolean[] visit = new boolean[numCourses];

        for (int crs=0; crs < numCourses; crs++) {
            if (!dfs(crs, visit)) return false;
        }

        return true;
    }

    private boolean dfs(int crs, boolean[] visit) {
        if (visit[crs]) return false;
        if (preMap.get(crs).isEmpty()) return true;

        visit[crs] = true;
        for (int pre : preMap.get(crs)) {
            if (!dfs(pre, visit)) return false;
        }
        visit[crs] = false;

        preMap.put(crs, new ArrayList<>());
        return true;
    }
}
