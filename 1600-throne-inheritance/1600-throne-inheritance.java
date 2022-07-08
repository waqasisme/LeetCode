
class ThroneInheritance {
    String OGMonarch;
    HashMap<String, List<String>> royalDirectory = new HashMap<>();
    HashSet<String> theDead = new HashSet<>();
    ArrayList<String> rankingOfKings = new ArrayList<>();
    
    public ThroneInheritance(String kingName) {
        this.OGMonarch = kingName;
        this.royalDirectory.put(kingName, new ArrayList());
    }
    
    public void birth(String parentName, String childName) {
        this.royalDirectory.get(parentName).add(childName);
        this.royalDirectory.put(childName, new ArrayList());
    }
    
    public void death(String name) {
        this.theDead.add(name);
    }
    
    public List<String> getInheritanceOrder() {
        // return non dead people using DFS
        this.rankingOfKings.clear();
        this.updateRankingOfKings(this.OGMonarch);
        
        return rankingOfKings;
    }
    
    public void updateRankingOfKings(String nextInLine) {
        if(!this.theDead.contains(nextInLine))
            this.rankingOfKings.add(nextInLine);
        
        for(String child: this.royalDirectory.get(nextInLine))
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