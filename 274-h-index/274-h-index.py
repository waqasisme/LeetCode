class Solution:
    def hIndex(self, citations: List[int]) -> int:
        citations.sort()
        h = 0
        for i in range(len(citations)):
            h = len(citations) - i
            
            if h <= citations[i]:
                return h
        
        return 0