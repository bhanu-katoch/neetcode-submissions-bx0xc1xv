class Solution {
    int nums[];
    int n;
    public boolean canJump(int[] nums) {
        this.nums =nums;
        n = nums.length;
        return dfs(0);
    }
    private boolean dfs(int index){
        if(index>=n-1)
            return true;
        for(int i=1;i<=nums[index];i++){
            if(dfs(index+i))
                return true;
        }
        return false;
    }
}
