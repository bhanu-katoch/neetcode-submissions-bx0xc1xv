class Solution {
    int target;
    int nums[];
    int n;
    int offset;
    Integer cache[][];
    public int findTargetSumWays(int[] nums, int target) {
        this.target = target;
        this.nums = nums;
        n = nums.length;
        int totalSum = Arrays.stream(nums).sum();
        offset = totalSum;
        this.cache = new Integer[n][2*totalSum+1];
        // System.out.println(Arrays.stream(nums).map(a->Math.abs(a)).sum());
        return dfs(0,0);
    }
    private int dfs(int index, int sum){
        if(index==n){
            return sum==target?1:0;
        }
        if(cache[index][sum+offset]!=null)
            return cache[index][sum+offset];
        return cache[index][sum+offset]=dfs(index+1,sum+nums[index]) + dfs(index+1,sum-nums[index]);
    }
}
