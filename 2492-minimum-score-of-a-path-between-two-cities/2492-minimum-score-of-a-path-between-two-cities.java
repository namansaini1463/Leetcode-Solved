class Solution {
    class DSU{
        int n;
        int[] parent;
        int[] size;

        int components;

        public DSU(int n){
            this.n = n;
            this.parent = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }

            this.size = new int[n];
            Arrays.fill(size, 1);

            this.components = 1;
        }

        public int findUltimateParent(int u){
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

            if(size[parentU] < size[parentV]){
                size[parentV] += size[parentU];
                parent[parentU] = parent[parentV];
            } else {
                size[parentU] += size[parentV];
                parent[parentV] = parent[parentU];
            }

            components++;
            return true;
        }


    }
    
    public int minScore(int n, int[][] roads) {
        DSU dsu = new DSU(n + 1);

        int minimumScore = Integer.MAX_VALUE;

        for(int[] road : roads){
            int u = road[0], v = road[1], w = road[2];

            dsu.union(u, v);
        }

        for(int[] road : roads){
            int u = road[0], v = road[1], w = road[2];

            if(dsu.find(1, u)){ // sirf first component wale edges ka minimum weight
                minimumScore = Math.min(minimumScore, w);
            }
        }


        // System.out.println(Arrays.toString(dsu.parent));
        // System.out.println(dsu.components);
        return minimumScore;
    }
}