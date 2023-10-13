class Solution:
    def closetTarget(self, words: List[str], target: str, startIndex: int) -> int:
        n = len(words)
        # moving right
        moveright = 0
        flag = False
        for i in range(startIndex,len(words)+startIndex):
            if words[(i+1)%n] == target:
                flag = True
                moveright += 1
                break
            else:
                moveright += 1
        # If target is not present so its no use searching to the left so we return -1
        if flag == False:
            return -1
        
        # moving left
        moveleft = 0
        pointer = startIndex
        while True:
            if words[pointer] == target:
                break
            else:
                pointer = (pointer - 1 + n) % n
                moveleft += 1
        return min(moveleft,moveright)