class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events,(a,b)->(a[0]!=b[0])?a[0]-b[0]: a[1]-b[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        int res=0, n=events.length;

        for(int i=1, j=0;i<=100000;i++){
            while(j<n && events[j][0]==i) 
                pq.add(events[j++]);
            
            if(pq.isEmpty()){
                if(j==n) break;
                i=events[j][0]-1;
            }else{
                while(!pq.isEmpty() && pq.peek()[1]<i) 
                    pq.poll();

                if(!pq.isEmpty()){
                    pq.poll();
                    res++;
                }
            }
        }
        return res;
    }
}