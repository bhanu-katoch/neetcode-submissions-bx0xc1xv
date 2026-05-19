class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int l=0;
        int r=n-1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(matrix[mid][0]==target){
                return true;
            }
            else if(target>matrix[mid][0] && target<=matrix[mid][m-1]){
                    int l_=0;
                    int r_=m-1;
                    while(l_<=r_){
                        int mid_ = l_ + (r_-l_)/2;
                        if(matrix[mid][mid_]==target)
                            return true;
                        else if(target<matrix[mid][mid_]){
                            r_ = mid_-1;
                        }
                        else{
                            l_ = mid_+1;
                        }
                    }
                    return false;
            }
            else if(target>matrix[mid][m-1]){
                    l = mid+1;
            } 
            else{
                System.out.println("1");
                r = mid-1;
            }
    }
        return false;
}
}

