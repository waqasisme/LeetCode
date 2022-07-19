public class Solution {
    public int[] SortedSquares(int[] nums) {
        int[] squares = new int[nums.Length];
        int left = 0, right = nums.Length - 1;
        
        for (int i = nums.Length - 1; i >= 0; i--) {
            if (Math.Abs(nums[left]) > Math.Abs(nums[right]))
                squares[i] = nums[left] * nums[left++];
            else squares[i] = nums[right] * nums[right--];
        }
        
        return squares;
    }
}