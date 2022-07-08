class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int l = 0;
        int r = n - 1;
        int idx = n - 1;
        
        while (l <= r)
            if (Math.abs(nums[l]) > Math.abs(nums[r]))
                result[idx--] = nums[l] * nums[l++];
            else 
                result[idx--] = nums[r] * nums[r--];
            
        return result;
    }
}