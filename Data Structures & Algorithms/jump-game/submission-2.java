class Solution {
    int nums[];
    int n;
    Boolean memo[];
    public boolean canJump(int[] nums) {
        this.nums =nums;
        n = nums.length;
        memo = new Boolean[n];
        return dfs(0);
    }
    private boolean dfs(int index){
        if(index>=n-1)
            return true;
        if(memo[index]!=null)
            return memo[index];
        for(int i=1;i<=nums[index];i++){
            if(dfs(index+i))
                return memo[index]=true;
        }
        return memo[index]=false;
    }
}
