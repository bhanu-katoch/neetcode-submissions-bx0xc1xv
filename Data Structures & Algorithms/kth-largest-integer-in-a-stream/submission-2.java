class KthLargest {
    PriorityQueue<Integer> maxH = new PriorityQueue<>((a,b)-> Integer.compare(b,a));
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int num: nums){
            maxH.offer(num);        
        }
    }
    
    public int add(int val) {
        maxH.add(val);
        int i=0;
        int kmax = 0;
        List<Integer> list = new ArrayList<>();
        while(i<k){
            if(i==k-1){
                kmax = maxH.poll();
                for(int ele: list){
                    maxH.offer(ele);
                }
                maxH.offer(kmax);
            }
            else{
                list.add(maxH.poll());
            }
            i++;
        }
        return kmax;
    }
}
