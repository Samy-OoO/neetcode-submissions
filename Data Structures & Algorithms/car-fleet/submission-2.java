class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        List<int[]> cars = new ArrayList<>();

        for (int i=0; i<n; i++) {
            cars.add(new int[]{position[i], speed[i]});
        }
        cars.sort((a, b) -> Integer.compare(b[0], a[0]));

        double time;
        Stack<Double> stack = new Stack<>();
        for (int[] car : cars){
            time = (double) (target - car[0]) / car[1];
            if ((!stack.isEmpty() && time > stack.peek()) 
                || stack.isEmpty())
            {
                stack.push(time);
            }
        }
        return stack.size();
    }
}
