
class Monarch {
    String name;
    public boolean alive = true;
    public List<Monarch> children = new ArrayList<>();
    
    public Monarch(String name) {
        this.name = name;
    }
        
}



class ThroneInheritance {
    Monarch OGMonarch; 
    HashMap<String, Monarch> royalDirectory = new HashMap<>();
    List<String> rankingOfKings = new ArrayList<>();
    
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
        this.rankingOfKings.clear();
        this.updateRankingOfKings(this.OGMonarch);    
        
        return rankingOfKings;
    }
    
    public void updateRankingOfKings(Monarch nextInLine) {
        if(nextInLine.alive)
            this.rankingOfKings.add(nextInLine.name);
        
        for(Monarch child: nextInLine.children)
            updateRankingOfKings(child);
    }
    
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */