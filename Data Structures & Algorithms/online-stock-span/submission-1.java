class StockSpanner {
    Deque<int[]> stack;
    public StockSpanner() {
        this.stack = new ArrayDeque<>();
    }
    
    public int next(int price) {
        int i=1;
        while(!stack.isEmpty() && stack.peek()[0]<=price){
            int[] p = stack.pop();
            i+=p[1];
        }
        stack.push(new int[]{price,i});
        return i;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */