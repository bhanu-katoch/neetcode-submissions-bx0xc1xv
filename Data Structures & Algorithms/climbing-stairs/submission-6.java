class Solution {
    int ways=0;
    int n;
    int memo[];
    public int climbStairs(int n) {
        this.n = n;
        memo = new int[n];
        Arrays.fill(memo,-1);
        return dfs(0);
    }
    private int dfs(int sum){
        if(sum==n){
            return 1;
        }
        else if(sum>n){
            return 0;
        }
        if(memo[sum]!=-1){
            return memo[sum];
        }
        return memo[sum]=dfs(sum+1)+dfs(sum+2);
    }
}
