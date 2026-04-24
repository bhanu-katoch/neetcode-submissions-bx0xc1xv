class Solution {
    int[][] grid;
    int rows;
    int cols;
    int[][] memo;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        this.grid = obstacleGrid;
        this.rows = obstacleGrid.length;
        this.cols = obstacleGrid[0].length;
        memo = new int[rows][cols];
        for(int i=0;i<rows;i++){
            Arrays.fill(memo[i],-1);
        }
        return dfs(0,0);
    }
    private int dfs(int row, int col){
        if(row<0 || row>=rows || col<0 || col>=cols){
            return 0;
        }
        if(grid[row][col]==1)
            return 0;
        if(row==rows-1 && col==cols-1)
            return 1;
        if(memo[row][col]!=-1)
            return memo[row][col];
        return memo[row][col] = dfs(row +1,col) + dfs(row,col+1);
    }
}