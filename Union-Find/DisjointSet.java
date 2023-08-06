class DisjointSet {
    public int[] parent;
    public int[] rank;
    
    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++) parent[i] = i;
    }
    
    public int findParent(int node) {
        if(this.parent[node]!=node) this.parent[node] = findParent(this.parent[node]);
        return this.parent[node];
    }
    
    public void union(int u, int v) {
        int uPar = findParent(u);
        int vPar = findParent(v);
        
        if(uPar == vPar) return;
        
        if(this.rank[uPar] < this.rank[vPar]) this.parent[uPar] = vPar;
        else if(this.rank[vPar] < this.rank[uPar]) this.parent[vPar] = uPar;
        else {
            this.parent[vPar] = uPar;
            this.rank[uPar]++;
        }
    }
}