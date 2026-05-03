class Solution {
    int[][] grid;
    int[][] memo;
    int rows;
    int cols;
    public int minPathSum(int[][] grid) {
        this.grid = grid;
        rows = grid.length;
        cols = grid[0].length;
        memo = new int[rows][cols];
        for(int i=0;i<rows;i++)
            Arrays.fill(memo[i],-1);
        return dfs(0,0);
    }
    private int dfs(int r, int c){
        if(r<0||c<0||r>=rows||c>=cols)
            return Integer.MAX_VALUE;
        if(r==rows-1 && c==cols-1)
            return grid[r][c];
        if(memo[r][c]!=-1)
            return memo[r][c];
        return memo[r][c] = grid[r][c]+Math.min(dfs(r+1,c),dfs(r,c+1));    
    }
}