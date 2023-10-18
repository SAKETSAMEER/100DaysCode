class Solution:
    def maxSubsequence(self, nums: List[int], k: int) -> List[int]:
        arr = sorted(nums)
        for i in range(len(nums) - k):
            nums.remove(arr[i])
        return nums