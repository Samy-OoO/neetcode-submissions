class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        List<int[]> cars = new ArrayList<>();
        
        for (int i=0; i<position.length; i++) {
            cars.add(new int[]{position[i], speed[i]});
        }
        cars.sort((a, b) -> Integer.compare(b[0], a[0]));

        double time;
        Stack <Double> stack = new Stack<>();
        for (int[] car : cars) {
            time = (double) (target - car[0])/car[1];
            while ((!stack.isEmpty() && time > stack.peek()) || stack.isEmpty()){
                stack.push(time);
            }
            
        }

        return stack.size();
    }
}
