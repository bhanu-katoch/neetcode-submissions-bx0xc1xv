class Solution {
    // int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
    int rows;
    int cols;
    int[][] grid;
    boolean[][] visited;
    public int islandPerimeter(int[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
        visited = new boolean[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1)
                    return dfs(i,j);
            }
        }
        return 0;
    }
    private int dfs(int i, int j){
        if(i>=rows || j>=cols || i<0 || j<0 || grid[i][j]==0){
            return 1;
        }
        if(visited[i][j])
            return 0;
        visited[i][j] = true;
        return dfs(i+1,j)+
                dfs(i-1,j)+
                dfs(i,j+1)+
                dfs(i,j-1); 

    }
}