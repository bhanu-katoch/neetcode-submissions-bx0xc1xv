class FreqStack {
    Map<Integer, Integer> freqMap = new HashMap<>(); // Stores: Value -> Current Frequency
    Map<Integer, Stack<Integer>> groupMap = new HashMap<>(); // Stores: Frequency -> Stack of elements
    int maxFreq = 0;

    public void push(int val) {
        // 1. Update frequency for this value
        int f = freqMap.getOrDefault(val, 0) + 1;
        freqMap.put(val, f);

        // 2. Keep track of the highest frequency globally
        if (f > maxFreq) maxFreq = f;

        // 3. Add the value to the stack corresponding to its frequency
        groupMap.computeIfAbsent(f, k -> new Stack<>()).push(val);
    }

    public int pop() {
        // 1. Get the most recent element from the highest frequency group
        int val = groupMap.get(maxFreq).pop();

        // 2. Decrement the frequency in our map
        freqMap.put(val, maxFreq - 1);

        // 3. If that frequency group is now empty, move down to the next frequency
        if (groupMap.get(maxFreq).isEmpty()) {
            maxFreq--;
        }

        return val;
    }
}
