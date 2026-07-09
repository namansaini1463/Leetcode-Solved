class DSU{
    int[] parent;
    int[] size;

    public DSU(int n){
        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }

        size = new int[n];
        Arrays.fill(size, 1);
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

        if(size[parentV] > size[parentU]){
            size[parentV] += size[parentU];
            parent[parentU] = parentV; 
        } else {
            size[parentU] += size[parentV];
            parent[parentV] = parentU; 
        }

        return true;

    }


}

class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int qlength = queries.length;
        boolean[] result = new boolean[qlength];
        
        DSU dsu = new DSU(n);

        for(int i = 1; i < n; i++){
            if(nums[i] - nums[i-1] <= maxDiff){
                dsu.union(i, i-1);
            }
        }

        for(int i = 0; i < qlength; i++){
            int[] query = queries[i];
            int u = query[0];
            int v = query[1];

            result[i] = dsu.find(u, v);


        }

        return result;
    }
}