class Solution {
    int arr[];
    public int maxTurbulenceSize(int[] arr) {
        this.arr = arr;
        int n = arr.length;
        if(n<2) return n;
        int max = 1;
        for(int i=0;i<n-1;i++){
            int prev = Integer.compare(arr[i],arr[i+1]);
            if(prev==0) continue;
            max = Math.max(max,2);
            for(int j=i+2;j<n;j++){
                int curr = Integer.compare(arr[j-1],arr[j]);
                if(curr==-(prev)){
                    max = Math.max(max,j-i+1);
                    prev = curr;
                }
                else break;
            }
        }
        return max;
    }
}