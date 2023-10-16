class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int countTarget = 0 , lessTarget = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]<target) lessTarget++;
            if(nums[i]==target) countTarget++;
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<countTarget; i++){
            ans.add(lessTarget + i);
        }
        return ans;




        // Arrays.sort(nums);
        // List<Integer> ans = new ArrayList();
        // int first = 0, last = nums.length-1, val = -1;
        // while(first<=last){
        //    int mid = (last+first) / 2;
        //    if(nums[mid] == target){
        //        val=mid; last = mid -1;
        //    }
        //    else if(nums[mid]>target){
        //        last = mid-1;
        //    }else{
        //        first = mid+1;
        //    }
        // }
        // first = 0; last = nums.length-1;
        // int val1 =-1;
        // while(first<=last){
        //    int mid = (last+first) / 2;
        //    if(nums[mid] == target){
        //        val1=mid; first = mid + 1;
        //    }
        //    else if(nums[mid]>target){
        //        last = mid-1;
        //    }else{
        //        first = mid+1;
        //    }
        // }
        // if(val==-1) return ans;
        // for(int i=val; i<=val1; i++){
        //     ans.add(i); 
        // }
        // return ans;
    }
}

//                               ANOTHER SOLUTION
//        Arrays.sort(nums);
//         List<Integer> ans = new ArrayList();
//         for(int i=0; i<nums.length; i++){
//             if(nums[i] == target) ans.add(i);
//         }
//         return ans;