class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxH = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        for(int s:stones){
            maxH.offer(s);
        }
        while(!maxH.isEmpty()&&maxH.size()>1){
            int s1 = maxH.poll();
            int s2 = maxH.poll();
            int rem = Math.abs(s1-s2);
            if(rem==0)
                continue;
            else
                maxH.offer(rem);
        }
        return maxH.isEmpty()?0:maxH.poll();
    }
}
