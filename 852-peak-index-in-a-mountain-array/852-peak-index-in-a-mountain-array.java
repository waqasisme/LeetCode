class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0, r = arr.length - 1, i;
        while (l < r) {
            i = (l + r) / 2;
            if (arr[i] < arr[i + 1])
                l = i + 1;
            else
                r = i;
        }
        return l;
        
    }
}