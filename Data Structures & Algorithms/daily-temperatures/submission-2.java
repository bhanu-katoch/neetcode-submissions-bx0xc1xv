class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int ans[] = new int[n];
        Deque<int[]> stack = new ArrayDeque<>();// monotonic inc stack
        for(int i=n-1;i>=0;i--){
            if(stack.isEmpty()){
                ans[i] = 0;
            }
            else if(stack.peek()[0]>temperatures[i]){
                ans[i] = stack.peek()[1]-i;
            }
            else{
                while(!stack.isEmpty()&&stack.peek()[0]<=temperatures[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    ans[i]=0;
                }
                else{
                    ans[i] = stack.peek()[1]-i;
                }
            }
            stack.push(new int[]{temperatures[i],i});

        }
        return ans;
    }
}
