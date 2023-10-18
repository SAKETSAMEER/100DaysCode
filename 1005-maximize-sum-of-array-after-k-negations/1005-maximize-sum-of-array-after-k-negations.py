class Solution:
    def largestSumAfterKNegations(self, nums: List[int], k: int) -> int :
        nums.sort()
        i = 0
        while i<len(nums) and k>0 and nums[i]<0 :
            nums[i] = -nums[i]
            i, k = i+1, k-1
        nums[nums.index(min(nums))] *= -1 if k&1 else 1
        return sum(nums) 