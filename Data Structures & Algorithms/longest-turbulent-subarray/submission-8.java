class Solution {
    int arr[];
    public int maxTurbulenceSize(int[] arr) {
        this.arr = arr;
        int n = arr.length;
        int max = 1;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(j>i && isTurbulent(i,j))
                    max = Math.max(max,j-i+1);
            }
        }
        return max;
    }
    private boolean isTurbulent(int start, int end){
        boolean flag = true;
        for(int i=start;i<=end;i++){
            if((i-start)%2==0){
                if(i<end){
                    if(arr[i+1]<arr[i])
                        continue;
                    else{
                        flag = false;
                        break;
                    }
                } 
                else continue;
                
            }
            else{
                if(i<end){
                    if(arr[i+1]>arr[i])
                        continue;
                    else{
                        flag = false;
                        break;
                    }
                }
                else if(i==end)
                    continue;   
                else{
                    flag = false;
                    break;
                }
            }
        }
        if(flag==true) return true;
        flag = true;
        for(int i=start;i<=end;i++){
            if((i-start)%2==0){
                if(i<end){
                    if(arr[i+1]>arr[i])
                        continue;
                    else{
                        flag = false;
                        break;
                    }
                }     
                else continue;
            }
                
            else{
                if(i<end){
                     if(arr[i+1]<arr[i])
                        continue;
                    else{
                        flag = false;
                        break;
                    }
                }
                else if(i==end) continue;
                else{
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }
}