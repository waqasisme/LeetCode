/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution : GuessGame {
    public int GuessNumber(int n) {
        int lo = 1, hi = n;
         
        while (true) {
            int mid = lo + ((hi - lo) / 2);
            
            int result = guess(mid);
            if (result == 0)
                return mid;
            
            if (result == 1) lo = mid + 1;
            else hi = mid - 1;      
        }
        
    }
}