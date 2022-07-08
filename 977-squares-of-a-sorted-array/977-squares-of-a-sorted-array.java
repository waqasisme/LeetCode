class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int l = 0;
        int r = nums.length - 1;
        int idx = nums.length - 1;
        
        while (l <= r)
            if (Math.abs(nums[l]) > Math.abs(nums[r]))
                result[idx--] = nums[l] * nums[l++];
            else 
                result[idx--] = nums[r] * nums[r--];
            
        return result;
    }
}