class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        int sum = 0;
        for(int num: nums) {
            sum += num; // total max sum
        }
        
        if(sum < target || -sum > target) {
            return 0; // not possible to reach this sum 
        }
        
        int[] table = new int[2 * sum + 1]; // + 1 to check number of ways to reach sum 0
        table[sum] = 1; // ways to reach sum or -sum = same sign for all = 1 way
        
        for (int i = 0; i < nums.length; i++) {
            int[] tempTable = new int[2 * sum + 1];
            for(int j = 0; j < 2 * sum + 1; j++) {
                if (table[j] != 0) {
                    tempTable[j + nums[i]] += table[j];
                    tempTable[j - nums[i]] += table[j];
                }
            }
            table = tempTable;
        }
    return table[sum + target];
    }
}