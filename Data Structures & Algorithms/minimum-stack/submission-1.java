class MinStack {
    Deque<Integer> stack;
    Deque<Integer> min_stack;
    public MinStack() {
        stack = new ArrayDeque<>();
        min_stack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(min_stack.isEmpty()||val<=min_stack.peek()){
            min_stack.push(val);
        }
    }
    
    public void pop() {
        int t = stack.pop();
        if(t==min_stack.peek()){
            min_stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min_stack.peek();
    }
}
