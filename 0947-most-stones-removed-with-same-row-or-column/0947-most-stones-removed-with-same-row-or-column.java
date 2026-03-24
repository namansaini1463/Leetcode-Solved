class DSU {
    int[] parent; int[] size;

    public DSU(int n){
        this.parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }

        this.size = new int[n];
        Arrays.fill(size, 1);
    }

    private int findUltimateParent(int u){
        if(parent[u] == u) return u;

        return parent[u] = findUltimateParent(parent[u]);
    }

    public boolean find(int u, int v){
        return findUltimateParent(u) == findUltimateParent(v);
    }

    public boolean union(int u, int v){
        int parentU = findUltimateParent(u);
        int parentV = findUltimateParent(v);

        if(parentU == parentV) return false;

        if(size[parentU] > size[parentV]){
            parent[parentV] = parentU;
            size[parentU] += size[parentV];
        } else {
            parent[parentU] = parentV;
            size[parentV] += size[parentU];
        }

        return true;
    }
}


class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        DSU dsu = new DSU(n);

        int components = n; // Initially each stone is its own component

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                int r1 = stones[i][0];
                int c1 = stones[i][1];
                
                int r2 = stones[j][0];
                int c2 = stones[j][1];

                if(r1 == r2 || c1 == c2){
                    if(dsu.union(i, j)){
                        components--;
                    }
                }
            }
        }

        return n - components; 
    }
}