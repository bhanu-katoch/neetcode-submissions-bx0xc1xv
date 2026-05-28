class Solution {
    Integer[][] cache;
    int n,amt;
    int[] coins;
    public int change(int amount, int[] coins) {
        n = coins.length;
        this.cache = new Integer[n][amount+1];
        this.coins = coins;
        this.amt = amount;
        return dfs(0,0);
    }
    private int dfs(int index, int a){
        if(index>=n || a>amt){
            return 0;
        }
        if(a==amt)
            return 1;
        if(cache[index][a]!=null){
            return cache[index][a];
        }
        if(cache[index][a]==null)
            cache[index][a]=0;
        
        return cache[index][a] = dfs(index,a+coins[index])+ dfs(index+1,a);
    }
}
