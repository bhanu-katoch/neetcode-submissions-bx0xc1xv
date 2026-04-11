class Solution {
    public int hammingWeight(int n) {
        int count=0;
        while(n!=0){
            // System.out.println(n&1);
            if((n&1)==1)
                count++;
            n >>=1;
        }
        return count;
    }
}
