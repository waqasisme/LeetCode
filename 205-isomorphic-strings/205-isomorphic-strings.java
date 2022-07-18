class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        
        HashMap<Character, Character> s2t = new HashMap();
        HashMap<Character, Character> t2s = new HashMap();
        
        for(int i = 0; i < s.length(); i++) {
            char _s = s.charAt(i);
            char _t = t.charAt(i);
            
            if(s2t.containsKey(_s) && s2t.get(_s) != _t)
                return false;
            
            if(t2s.containsKey(_t) && t2s.get(_t) != _s)
                return false;
            
            s2t.putIfAbsent(_s, _t);
            t2s.putIfAbsent(_t, _s);
            
        }
            
            
        return true;
    }
}
