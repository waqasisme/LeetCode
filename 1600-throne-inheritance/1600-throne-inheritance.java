
class Monarch {
    String name;
    public boolean alive = true;
    public ArrayList<Monarch> children = new ArrayList<>();
    
    public Monarch(String name) {
        this.name = name;
    }
        
}



class ThroneInheritance {
    Monarch OGMonarch; 
    HashMap<String, Monarch> royalDirectory = new HashMap<>();
    
    
    public ThroneInheritance(String kingName) {
        this.OGMonarch = new Monarch(kingName);
        this.royalDirectory.put(kingName, this.OGMonarch);
    }
    
    public void birth(String parentName, String childName) {
        Monarch longLiveTheNewKing = new Monarch(childName);
        this.royalDirectory.get(parentName).children.add(longLiveTheNewKing);
        this.royalDirectory.put(childName, longLiveTheNewKing);
    }
    
    public void death(String name) {
        this.royalDirectory.get(name).alive = false;
    }
    
    public List<String> getInheritanceOrder() {
        // return non dead people using DFS
        List<String> rankingOfKings = getRankingOfKings(this.OGMonarch, new ArrayList<String>());
        return rankingOfKings;
    }
    
    public List<String> getRankingOfKings(Monarch nextInLine, List<String> rankingOfKings) {
        
        if(nextInLine.alive)
            rankingOfKings.add(nextInLine.name);
        
        for(Monarch child: nextInLine.children)
            getRankingOfKings(child, rankingOfKings);
        
        return rankingOfKings;
    }
    
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */