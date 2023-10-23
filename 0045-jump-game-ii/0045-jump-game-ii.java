class Solution {
    public int jump(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        int currReach=0, i=0, jumps=0, prevReach=0;
        for(int x:nums){
            currReach = Math.max(currReach,i+x);
            if(currReach>=nums.length-1){
                return jumps+1;
            }
            if(i==prevReach){
                jumps++;
                prevReach = currReach;
            }
            i++;
        }
        return jumps;
    }
}
