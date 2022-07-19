public class Solution {
    public double Average(int[] salary) {
        double min = Double.PositiveInfinity, max = Double.NegativeInfinity; 
        double total = 0;
        foreach (int sal in salary) {
            total += sal;
            if (sal < min) min = sal;
            if (sal > max) max = sal;
        }
            
        return (total - min - max) / (salary.Length - 2);
        
    }
}