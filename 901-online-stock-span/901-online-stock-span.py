class StockSpanner:

    def __init__(self):
        self.stack = []
        
    def next(self, price: int) -> int:
        min_days = 1
        
        while self.stack and self.stack[-1][0] <= price:
            min_days += self.stack.pop()[1]
            
        self.stack.append((price, min_days))
        return min_days
        
        
        
# Your StockSpanner object will be instantiated and called as such:
# obj = StockSpanner()
# param_1 = obj.next(price)