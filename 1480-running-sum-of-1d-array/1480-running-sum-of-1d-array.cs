public class Solution {
    public int[] RunningSum(int[] nums) {
        int[] runningSums = new int[nums.Length];
        
        for(int i = 0; i < nums.Length; i++) {
            runningSums[i] = runningSums[(i - 1) < 0 ? 0: (i - 1)] + nums[i];
        }
        
        return runningSums;
    }
}