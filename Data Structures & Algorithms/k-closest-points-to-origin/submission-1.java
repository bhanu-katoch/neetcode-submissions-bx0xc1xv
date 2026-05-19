class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minH = new PriorityQueue<>((a,b)->{
            double a_dist = Math.pow((Math.pow(a[0],2) + Math.pow(a[1],2)),0.5);
            double b_dist = Math.pow((Math.pow(b[0],2) + Math.pow(b[1],2)),0.5);
            return Double.compare(a_dist,b_dist);
        });
        for(int p[]: points){
            minH.offer(p);
        }
        int[][] ans = new int[k][2];
        for(int i=0;i<k;i++){
            ans[i] = minH.poll();
        }
        return ans;
    }
}
