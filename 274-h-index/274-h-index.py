class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        citations.sort()
        h = 0
        for i in range(n):
            h = n - i
            
            if h <= citations[i]:
                return h
        
        return 0