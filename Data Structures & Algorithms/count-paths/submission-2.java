class Solution {
    int[][] cache;
    int n,m;
    public int uniquePaths(int m, int n) {
        this.cache = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(cache[i],-1);
        }
        this.n = n;
        this.m = m;
        return dfs(0,0);
    }
    private int dfs(int r, int c){
        if(r<0||c<0||r>=m||c>=n){
            return 0;
        }
        if(r==m-1 && c==n-1)
            return 1;
        if(cache[r][c]!=-1){
            return cache[r][c];
        }
        return cache[r][c] = dfs(r+1,c)+dfs(r,c+1);
    }
}
