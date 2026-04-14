class Solution {
    List<List<Integer>> total = new ArrayList<>();
    int[] nums;
    int n;
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        this.n =nums.length;
        dfs(0,new ArrayList<>());
        return total;
    }
    private void dfs(int index, List<Integer> subset){
        if(index==n){
            total.add(new ArrayList<>(subset));
            return;
        }
        dfs(index+1,subset);
        subset.add(nums[index]);
        dfs(index+1,subset);
        subset.remove(subset.size()-1);
    }
}
