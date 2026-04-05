class Solution {
    int sum = 0;
    int n;
    int[] nums;
    public int subsetXORSum(int[] nums) {
        Deque<Integer> subset = new ArrayDeque<>();
        this.nums =nums;
        n = nums.length;
        dfs(0,subset);
        return sum;
    }
    private void dfs(int index, Deque<Integer> subset){
        if(index>=n){
            int xor=0;
            for(int ele: subset){
                xor^=ele;
            }
            sum+=xor;
            return;
        }
        subset.push(nums[index]);
        dfs(index+1,subset);
        subset.pop();
        dfs(index+1,subset);
    }
}