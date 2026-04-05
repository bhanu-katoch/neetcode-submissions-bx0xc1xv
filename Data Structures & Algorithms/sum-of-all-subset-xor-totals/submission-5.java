class Solution {
    int sum = 0;
    int n;
    int[] nums;
    public int subsetXORSum(int[] nums) {
        List<Integer> subset = new ArrayList<>();
        this.nums =nums;
        n = nums.length;
        dfs(0,subset);
        return sum;
    }
    private void dfs(int index, List<Integer> subset){
        if(index>=n){
            int xor=0;
            for(int ele: subset){
                xor^=ele;
            }
            sum+=xor;
            return;
        }
        subset.add(nums[index]);
        dfs(index+1,subset);
        subset.remove(subset.size()-1);
        dfs(index+1,subset);
    }
}