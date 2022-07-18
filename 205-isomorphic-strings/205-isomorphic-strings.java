class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        
        HashMap<Character, Character> s2t = new HashMap();
        HashMap<Character, Character> t2s = new HashMap();
        
        for(int i = 0; i < s.length(); i++) {
            
            if(s2t.containsKey(s.charAt(i)) && s2t.get(s.charAt(i)) != t.charAt(i))
                return false;
            
            if(t2s.containsKey(t.charAt(i)) && t2s.get(t.charAt(i)) != s.charAt(i))
                return false;
            
            s2t.putIfAbsent(s.charAt(i), t.charAt(i));
            t2s.putIfAbsent(t.charAt(i), s.charAt(i));
            
        }
            
            
        return true;
    }
}
