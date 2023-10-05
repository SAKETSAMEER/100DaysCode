class Solution:
    def countSymmetricIntegers(self, l, h):
        ans = 0
        for i in range(l, h + 1):
            c = 0
            j = i
            while j > 0:
                c += 1
                j = j // 10
            if c % 2 != 0:
                continue

            j = i
            s = 0
            a = 0
            b = 0
            while s < (c // 2):
                a += j % 10
                j = j // 10
                s += 1
            while s < c:
                b += j % 10
                j = j // 10
                s += 1
            if a == b:
                ans += 1
        return ans

# Usage example
solution = Solution()
l = 1  # Replace with your desired values for the range
h = 100
result = solution.countSymmetricIntegers(l, h)
print(result)