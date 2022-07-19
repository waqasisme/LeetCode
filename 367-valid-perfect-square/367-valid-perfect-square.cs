public class Solution {
    public bool IsPerfectSquare(int num) {
        if (num == 1) return true;
        
        for (int i = 0; i <= num / 2; i++)
            if (i * i == num) return true;
        
        return false;
    }
}