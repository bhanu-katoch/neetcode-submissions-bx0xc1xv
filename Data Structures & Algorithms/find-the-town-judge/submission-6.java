class Solution {
    public int findJudge(int n, int[][] trust) {
        for(int i=1;i<trust.length;i++){
            if(trust[i][1]!=trust[i-1][1])
                return -1;
        }
        return trust[0][1];
    }
}