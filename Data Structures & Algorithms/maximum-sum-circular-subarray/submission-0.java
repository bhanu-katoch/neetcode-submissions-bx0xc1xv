class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=i;j<n+i;j++){
                sum+=nums[j%n];
                max = Math.max(max,sum);
            }
        }
        return max;
    }
}