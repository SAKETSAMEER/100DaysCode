class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(i<n-1){
                if(nums[i]==nums[i+1]){
                    nums[i]*=2;
                    nums[i+1]=0;
                }
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                count++;
            }
        }
        for(int i=0; i<n;i++){
            if(nums[i]!=0){
                list.add(nums[i]);
            }
        }
        for(int i=0; i<count; i++){
            list.add(0);
        }
       for (int i = 0; i < list.size(); i++){
            nums[i] = list.get(i);
    }
        return nums;
    }
}