class Solution {
    public static String intToRoman(int num) {
        String thous[] = {"", "M", "MM", "MMM"};
        String hunds[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String tens[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String units[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return thous[num/1000] + hunds[(num%1000)/100] + tens[(num%100)/10] + units[num%10];
    }
}