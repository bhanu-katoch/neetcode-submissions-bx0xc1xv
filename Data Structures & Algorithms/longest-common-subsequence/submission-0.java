class Solution {
    char[] arr1;
    char[] arr2;
    int n,m;
    int memo[][];
    public int longestCommonSubsequence(String text1, String text2) {
        arr1 = text1.toCharArray();
        arr2 = text2.toCharArray();
        n = arr1.length;
        m = arr2.length;
        memo = new int[n][m];
        for(int i=0;i<n;i++)
            Arrays.fill(memo[i],-1);
        return dfs(0,0);
    }
    private int dfs(int i, int j){
        if(i>=n||j>=m)
            return 0;
        if(memo[i][j]!=-1)
            return memo[i][j];
        if(arr1[i]==arr2[j])
            return memo[i][j]=1+dfs(i+1,j+1);
        else
            return memo[i][j]=Math.max(dfs(i+1,j),dfs(i,j+1));
    }
}
