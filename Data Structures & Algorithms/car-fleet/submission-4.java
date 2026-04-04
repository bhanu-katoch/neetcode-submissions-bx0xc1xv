class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n <= 1) return n;

        // Use a map to sort cars by position in descending order
        TreeMap<Integer, Double> cars = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            // Calculate time to reach target as a double for precision
            double time = (double) (target - position[i]) / speed[i];
            cars.put(position[i], time);
        }

        Stack<Double> stack = new Stack<>();
        for (double time : cars.values()) {
            // If the car takes longer than the fleet in front, it forms a new fleet
            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }
            // If time <= stack.peek(), it joins the existing fleet; we do nothing
        }

        return stack.size();
    }
}

