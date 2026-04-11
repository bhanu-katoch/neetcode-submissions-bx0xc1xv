class Solution {
    public int[] countBits(int n) {
        int out[] = new int[n+1];
        if(n==0){
            return out;
        }
        out[1] = 1;
        int f = 0;
        int p = 2;
        for(int i=2;i<=n;i++){
            if(i==p){
                out[i] =1;
                f=1;
                p*=2;
            }
            else{
                out[i] = out[f++] + 1;
            }
        }
        return out;
    }
}
