class Solution {
    Integer cache[][];
    int target;
    int n;
    int[] stones;
    int sumStones;
    public int lastStoneWeightII(int[] stones) {
        this.sumStones = Arrays.stream(stones).sum();
        this.n = stones.length;
        this.stones = stones;

        this.target = sumStones/2;
        cache = new Integer[n][sumStones];
        return dfs(0,0);
    }
    private int dfs(int i, int total){
        if(i>=n || total>=target){
            return Math.abs(total-(sumStones-total));
        }
        if(cache[i][total]!=null){
            return cache[i][total];
        }
        return cache[i][total] = Math.min(dfs(i+1,total),dfs(i+1,total+stones[i]));
    }
}