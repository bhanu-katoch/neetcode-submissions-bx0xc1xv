// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
//         int n = matrix.length;
//         int m = matrix[0].length;
//         int l=0;
//         int r=n-1;
//         while(l<=r){
//             int mid = l + (r-l)/2;
//             if(matrix[mid][0]==target){
//                 return true;
//             }
//             else if(target>matrix[mid][0]){
//                 System.out.println("1");
//                 if(target<matrix[mid][m-1]){
//                     int l_=mid;
//                     int r_=m-1;
//                     while(l_<=r_){
//                         int mid_ = l_ + (r_-l_)/2;
//                         if(matrix[mid][mid_]==target)
//                             return true;
//                         else if(target<matrix[mid][mid_]){
//                             r_ = mid_-1;
//                         }
//                         else{
//                             l_ = mid_+1;
//                         }
//                     }
//                     return false;
//                 }
//                 else{
//                     l = mid+1;
//                 }  
//             }
//             else{
//                 System.out.println("2");
//                 r = mid-1;
//             }
//         }
//         return false;
//     }
// }
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int l = 0;
        int r = n - 1;
        
        while (l <= r) { // Fix 1: Changed < to <= to check single-row matrices
            int mid = l + (r - l) / 2;
            
            if (matrix[mid][0] == target) {
                return true;
            }
            // Check if target falls within the current row's range
            else if (target > matrix[mid][0] && target <= matrix[mid][m - 1]) { // Fix 2: Changed < to <=
                int l_ = 0;      // Fix 3: Started column pointer at 0, not mid
                int r_ = m - 1;
                
                while (l_ <= r_) { // Fix 4: Changed < to <=
                    int mid_ = l_ + (r_ - l_) / 2;
                    if (matrix[mid][mid_] == target) {
                        return true;
                    } else if (target < matrix[mid][mid_]) {
                        r_ = mid_ - 1;
                    } else {
                        l_ = mid_ + 1;
                    }
                }
                return false; // Target was supposed to be in this row but wasn't
            }
            else if (target > matrix[mid][m - 1]) { // Fix 5: Move down if target is larger than row end
                l = mid + 1;
            }
            else { // Fix 6: Move up if target is smaller than row start
                r = mid - 1;
            }
        }
        return false;
    }
}
