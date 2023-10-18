class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        finPermu(nums, 0, res);
        return res;
    }
    private void finPermu(int nums[], int startIndx, List<List<Integer>> res){
        int sz = nums.length;
        for(var num : nums){
            System.out.print(num+" ");
        }
        System.out.println();
        if(startIndx == sz){
            List<Integer> currPer = new ArrayList<>();
            for(var num : nums)currPer.add(num);
            res.add(currPer);
            return;
        }
        for(int leftPtr = startIndx ; leftPtr < sz; leftPtr++){
                swap(nums, startIndx, leftPtr);
                finPermu(nums, startIndx+1, res);
                swap(nums, startIndx, leftPtr);
        }
    }
    private void swap(int nums[], int indx1, int indx2){
        int tempNum = nums[indx1];
        nums[indx1] = nums[indx2];
        nums[indx2] = tempNum;
    }

}