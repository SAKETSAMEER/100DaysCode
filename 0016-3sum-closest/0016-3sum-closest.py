class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        nums.sort()
        
        ans = sum(nums[:3])
        
        for i in range(len(nums)-2):
			# some simple checking 
            if i>0 and nums[i] == nums[i-1]: continue
            cur_minsum = nums[i] + nums[i+1] + nums[i+2]
            cur_maxsum = nums[i] + nums[-2] + nums[-1]
            if cur_minsum >= target:
                if abs(cur_minsum-target) < abs(ans-target):
                    return cur_minsum
                else: return ans
            if cur_maxsum < target:
                if abs(cur_maxsum-target) < abs(ans-target):
                    ans = cur_maxsum
                continue
            
			# two pointer searching
            j = i+1
            k = len(nums)-1
            while j < k:
                s = nums[i]+nums[j]+nums[k] 
                if s == target:
                    return target
                if abs(target-s) < abs(target-ans):
                    ans = s
                
                if s < target:
                    j += 1
                else:
                    k -= 1
                
                
        return ans