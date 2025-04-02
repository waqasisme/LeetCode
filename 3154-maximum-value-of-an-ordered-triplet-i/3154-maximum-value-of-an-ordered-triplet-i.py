class Solution:
    def calcTriplet(self, i: int, j: int, k: int):
        return (i - j) * k    
    
    def maximumTripletValue(self, nums: List[int]) -> int:
        result = 0
        N = len(nums)
        i = 0
        for j in range(1, N):
            if (nums[j] > nums[i]):
                i = j
                continue
            
            for k in range(j+1, N):
                    result = max(result, self.calcTriplet(nums[i], nums[j], nums[k]))
        
        return result