class Solution:
    def numberOfPoints(self, nums: List[List[int]]) -> int:
        covered_points = []
        for start,end in nums:
            covered_points.extend(range(start,end+1))
        unique_points = set(covered_points)
        return len(unique_points)