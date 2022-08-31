class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        return [first for first, second in Counter(nums).most_common(k)]