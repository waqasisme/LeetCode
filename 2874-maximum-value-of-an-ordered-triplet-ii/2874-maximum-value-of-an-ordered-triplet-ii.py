class Solution:
    def maximumTripletValue(self, nums: List[int]) -> int:
        prefix_max = nums[0]
        max_diff = 0
        result = 0

        for k in range(1, len(nums)):
            result = max(result, max_diff * nums[k])
            max_diff = max(max_diff, prefix_max - nums[k])
            prefix_max = max(prefix_max, nums[k])

        return result