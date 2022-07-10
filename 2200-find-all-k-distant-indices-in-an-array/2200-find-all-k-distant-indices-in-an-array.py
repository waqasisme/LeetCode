class Solution:
    def findKDistantIndices(self, nums: List[int], key: int, k: int) -> List[int]:
        res = []
        n = len(nums)
        j = 0
        for i in range(n):
            if nums[i] == key:
                j = max(i - k, j)
                while j < n and j <= i + k:
                    res.append(j)
                    j += 1
                
        return res