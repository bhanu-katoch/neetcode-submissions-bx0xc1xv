class Solution {
    int[] prices;
    int n;
    Integer[][] cache;
    public int maxProfit(int[] prices) {
        this.n = prices.length;
        this.prices = prices;
        this.cache = new Integer[n][3];
        return dfs(0,0); 
    }
    private int dfs(int index, int state){
        if(index>=n){
            return 0;
        }
        /*
            state = 0 -> cooldown
            state = 1 -> buy
            state = 2 -> sell
        */
        if(cache[index][state]!=null){
            return cache[index][state];
        }
        if(state==0){//cooldown
            return cache[index][state]=Math.max(-prices[index]+dfs(index+1,1),dfs(index+1,state));
        }
        else if(state==1){// buy
            return cache[index][state]=Math.max(prices[index]+dfs(index+1,2),dfs(index+1,state));
        }
        else// sell
            return cache[index][state]=dfs(index+1,0);
    }
}
