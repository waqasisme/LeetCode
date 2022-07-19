import itertools

class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        triangle = [[1], [1, 1]]
        
        for i in range(3, numRows + 1):
            last_row = triangle[-1]
            triangle.append([1] + [sum(pair) for pair in pairwise(last_row)] + [1])
            
        return triangle[:numRows]