class Solution:
    def peopleAwareOfSecret(self, n: int, delay: int, forget: int) -> int:
        days = [0] * n
        days[0] = 1
        
        for i in range(delay, n):
            if i < forget - 1:
                days[i] = sum(days[: i - delay + 1])
            else:
                days[i] = sum(days[i - forget + 1:i - delay + 1])

        return sum(days[n - forget:]) % (10**9 + 7)