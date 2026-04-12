class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list= new ArrayList<>();
        int n = intervals.length;
        for(int i=0;i<n;i++){
            if(newInterval[1]<intervals[i][0]){
                list.add(newInterval);
                return merge(list,i,intervals);
            }
            else if(newInterval[0]>intervals[i][1]){
                list.add(intervals[i]);
            }
            else{
                newInterval = new int[]{Math.min(newInterval[0],intervals[i][0]),Math.max(newInterval[1],intervals[i][1])};
            }
        }
        list.add(newInterval);
        int[][] out = new int[list.size()][2];
        for(int i=0;i<list.size();i++){
            out[i][0]=list.get(i)[0];
            out[i][1]=list.get(i)[1];
        }
        return out;
    }
    private int[][] merge(List<int[]> list, int len, int[][] intervals){
        int n = intervals.length;
        int size = list.size()+n-len;
        int[][] out = new int[size][2];
        int i=0;
        for(i=0;i<list.size();i++){
            out[i][0] = list.get(i)[0];
            out[i][1] = list.get(i)[1];
        }
        for(;i<size;i++){
            out[i][0] = intervals[len][0];
            out[i][1] = intervals[len][1];
            len++;
        }
        return out;

    }
}
