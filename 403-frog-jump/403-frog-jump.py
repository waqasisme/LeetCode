class Solution:
    
    def canCross(self, stones: List[int]) -> bool:
        self.memo = {}
        self.n = len(stones)
        self.positions = set(stones)
        
        return self.canCrossHelper(stones, self.n, 1, 1)
        
        
    
    def canCrossHelper(self, stones, n, curr_pos, last_jump):
        print((curr_pos, last_jump))
        if (curr_pos, last_jump) not in self.memo and curr_pos in self.positions:
            if curr_pos == stones[-1]: # reached the end
                self.memo[(curr_pos, last_jump)] = True
            else:    
                self.memo[(curr_pos, last_jump)] = any([self.canCrossHelper(stones, n, curr_pos + last_jump + i, last_jump + i) for i in [-1, 0, 1] if last_jump + i > 0])
            
        return self.memo.get((curr_pos, last_jump), False) # curr_pos not in stone positions
        
        
    
    
        

        
    