class Solution:
    def replaceElements(self, arr: List[int]) -> List[int]:
        #ans = [0]*len(arr)
        maxele = -1
        for i in range(len(arr)-1,-1,-1):
            temp = maxele
            maxele = max(maxele,arr[i])
            arr[i] = temp
           
        return arr
