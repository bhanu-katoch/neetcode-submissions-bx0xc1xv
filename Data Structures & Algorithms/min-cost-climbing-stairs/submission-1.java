class Solution {
    int memo[];
    int n;
    int cost[];
    public int minCostClimbingStairs(int[] cost) {
        this.n = cost.length;
        this.cost = cost;
        this.memo = new int[n];
        Arrays.fill(memo,-1);
        return Math.min(dfs(0),dfs(1));
    }
    private int dfs(int index){
        if(index>=n){
            return 0;
        }
        if(memo[index]!=-1)
            return memo[index];
        return memo[index] = cost[index]+Math.min(dfs(index+1),dfs(index+2));
    }

}
