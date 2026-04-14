class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        int n= intervals.length;
        for(int i=0;i<n;i++){
            list.add(intervals[i]);
        }
        Collections.sort(list,(a,b)->{
            if(a[0]!=b[0]){
                return Integer.compare(a[0],b[0]);
            }
            else{
                return Integer.compare(a[1],b[1]);
            }
        });
        for(int i=1;i<n;i++){
            int a = list.get(i)[0];
            int b = list.get(i)[1];
            int a_ = list.get(i-1)[0];
            int b_ = list.get(i-1)[1];
            if(a<=b_){
                list.remove(i);
                list.remove(i-1);
                list.add(i-1,new int[]{Math.min(a,a_),Math.max(b,b_)});
                i--;
                n-=1;
            }
        }
        int[][] out = new int[list.size()][2];
        int i=0;
        for(int[] inte:list){
            out[i][0] = inte[0];
            out[i][1] = inte[1];
            i++;
        }
        return out;
    }
}
