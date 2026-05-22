class Solution {
    int n;
    Integer memo[];
    int nums[];
    public int jump(int[] nums) {
        this.nums = nums;
        n = nums.length;
        memo = new Integer[n];
        return dfs(0);
    }
    private int dfs(int index){
        if(index>=n-1) return 0;
        if(memo[index]!=null){
            return memo[index];
        }
        int min = 100000;//Integer.MAX_VALUE;
        for(int i=1;i<=nums[index];i++){
            min = Math.min(min,dfs(index+i)+1);
        }

        return memo[index]=min;
    }
}
// class Solution {
//     int n;
//     Integer memo[];
//     int nums[];

//     public int jump(int[] nums) {
//         this.nums = nums;
//         this.n = nums.length;
//         this.memo = new Integer[n];
//         return dfs(0);
//     }

//     private int dfs(int index) {
//         // Base case: reached or passed the last index
//         if (index >= n - 1) return 0;
        
//         // Return cached result
//         if (memo[index] != null) return memo[index];

//         int minJumps = 10001; // Problem constraint usually max 10^4, or use a large constant

//         // Try every possible jump from 1 to nums[index]
//         for (int i = 1; i <= nums[index]; i++) {
//             minJumps = Math.min(minJumps, 1 + dfs(index + i));
//         }

//         return memo[index] = minJumps;
//     }
// }
