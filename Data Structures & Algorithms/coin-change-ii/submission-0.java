// class Solution {
//     Integer[][] cache;
//     int n,amt;
//     int[] coins;
//     public int change(int amount, int[] coins) {
//         n = coins.length;
//         this.cache = new Integer[n][amount];
//         this.coins = coins;
//         this.amt = amount;
//         return dfs(0,0);
//     }
//     private int dfs(int index, int a){
//         if(index>=n || a>amt){
//             return 0;
//         }
//         if(a==amt)
//             return 1;
//         if(cache[index][a]!=null){
//             return cache[index][a];
//         }
//         if(cache[index][a]==null)
//             cache[index][a]=0;
//         for(int i=index;i<n;i++){
//             int coin = coins[i];
//             cache[index][a]+=dfs(index+1,a+coin);
//         }
//         return cache[index][a];
//     }
// }
class Solution {
    Integer[][] cache;
    int[] coins;

    public int change(int amount, int[] coins) {
        this.cache = new Integer[coins.length][amount + 1];
        this.coins = coins;
        return dfs(0, amount);
    }

    private int dfs(int index, int remaining) {
        // Base cases
        if (remaining == 0) return 1;
        if (index >= coins.length || remaining < 0) return 0;
        
        if (cache[index][remaining] != null) return cache[index][remaining];

        // Choice 1: Use the coin (stay at index) + Choice 2: Skip the coin (next index)
        int take = dfs(index, remaining - coins[index]);
        int skip = dfs(index + 1, remaining);

        return cache[index][remaining] = take + skip;
    }
}
